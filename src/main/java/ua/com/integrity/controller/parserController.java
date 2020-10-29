package ua.com.integrity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.com.integrity.dto.ExcelData;
import ua.com.integrity.dto.ParsedFiles;
import ua.com.integrity.entity.Audit;
import ua.com.integrity.entity.Defect;
import ua.com.integrity.entity.Observation;
import ua.com.integrity.parser.Parser;
import ua.com.integrity.service.AuditService;
import ua.com.integrity.service.DefectService;
import ua.com.integrity.service.ObservationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class parserController {

    @Autowired
    private AuditService auditService;

    @Autowired
    private ObservationService observationService;

    @Autowired
    private DefectService defectService;

    @PostMapping(value = "/")
    public ResponseEntity<List<ParsedFiles>> parse(@RequestParam("file") MultipartFile[] files) {
        List<ParsedFiles> parsedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            List<ExcelData> data = Parser.parse(file);
            Audit audit = auditService.create(new Audit());

            ParsedFiles parsedFile = new ParsedFiles();
            parsedFile.setFileName(file.getOriginalFilename());
            parsedFile.setAuditId(audit.getId());
            parsedFiles.add(parsedFile);

            ExcelData currObservation = data.get(0);
            List<ExcelData> currObservationRows = new ArrayList<>();
            currObservationRows.add(currObservation);

            for (int i = 1; i < data.size(); i++) {
                if (data.get(i).getObservationArea().equals(currObservation.getObservationArea()) &&
                        data.get(i).getObservation().equals(currObservation.getObservation()))
                {
                    currObservationRows.add(data.get(i));
                } else {
                    createObservationAndItsDefects(audit, currObservationRows, currObservation, observationService, defectService);

                    currObservation = data.get(i);
                    currObservationRows.clear();
                    currObservationRows.add(currObservation);
                }
            }

            createObservationAndItsDefects(audit, currObservationRows, currObservation, observationService, defectService);
        }

        return ResponseEntity.ok(parsedFiles);
    }

    private static void createObservationAndItsDefects (Audit audit, List<ExcelData> currObservationRows, ExcelData currObservation, ObservationService observationService, DefectService defectService) {
        Observation observation = observationService.create(new Observation(audit, currObservation.getObservationArea(), currObservation.getObservation()));

        List<Defect> defectsForCurrObservation = currObservationRows.stream()
                .map(el -> new Defect(observation, el.getBpCode(), el.getObservationDescription(), el.getRootCause(), el.getRiskType(), el.getRiskCategory(), el.getRiskLevel(), el.getRecommendations(), el.getInspector(), el.getObservationRepetitionFeature(), el.getLastObservationYear(), el.getGeneralCount(), el.getSampleNumber(), el.getDeviationCount(), el.getActualLoss(), el.getPotentialLoss(), el.getReputational(), el.getRegulatory(), el.getBusinessProcess(), el.getSeverity()))
                .collect(Collectors.toList());
        defectService.createAllForObservation(defectsForCurrObservation);
    }
}
