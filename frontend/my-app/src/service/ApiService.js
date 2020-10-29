import axios from 'axios';

class ApiService {

    upload(data) {
        return axios.post("http://localhost:3000/", data);
    }
}

export default new ApiService();