import axios from "axios"

export const Service = {

    getSearch: function(data, select) {return axios.get(`http://localhost:8080/hospital/search?q=${data}&value=${select}`)},

}

export default Service;