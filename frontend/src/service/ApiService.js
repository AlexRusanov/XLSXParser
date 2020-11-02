import axios from 'axios';

class ApiService {

    upload(data) {
        return axios.post("/api", data);
    }
}

export default new ApiService();