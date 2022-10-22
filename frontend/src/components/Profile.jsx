import React, { useState, useEffect }  from 'react';
import Navbar from '../components/Navbar';
import Service from '../service/service';
import axios from 'axios';

const Profile = () => {

    const [user, setUser] = useState({
        nombreYApellido: "",
        dni: "",
        email: "",
        telefono: "",
        password: "",
    });

    const isLogged = !!localStorage.getItem("token");

    axios.defaults.headers['authorization'] = localStorage.getItem('token');

    useEffect(() => {
        if (isLogged){
          Service.getUser()
          .then(response => {
            setUser({
              id: response.data.id,
              nombreYApellido: response.data.nombreYApellido,
              email: response.data.dni,
              telefono: response.data.dni,  
            })
          }).catch(error => {
            console.log(error)
          });
        }}, [isLogged]
    );  

    console.log(user)

    return (
        <>
            <div className="navbar">
                <Navbar/>
            </div> 
        </>  
    );
};
  
export default Profile;