import React, { useState } from 'react';
import ApiService from '../service/ApiService';

function FileUploader(props) {
    const [result, setResult] = useState([]);

    const onFileChangeHandler = (e) => {
        const formData = new FormData();
        for(let i = 0; i< e.target.files.length; i++) {
            formData.append('file', e.target.files[i])
        }
        ApiService.upload(formData)
            .then(res => {
                setResult(res.data)
            })
    };
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                    <div className="form-group files color">
                        <label>Upload Your File </label>
                        <input type="file" className="form-control" name="file" multiple onChange={onFileChangeHandler}/>
                        {result.length > 0 && result.map((item, i) => {
                            return <li key={i}>Файл {item.fileName} загружен в базу под ID № {item.auditId} </li>
                        })}
                    </div>
                </div>
            </div>
        </div>
    )
}

export default FileUploader;