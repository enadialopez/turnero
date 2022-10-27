import React, { useState, useEffect }  from 'react';
import Navbar from '../components/Navbar';
import Service from '../service/service';
import axios from 'axios';
import '../styles/Profile.css';

const Profile = () => {

    const [user, setUser] = useState({
        id: "",
        nombreYApellido: "",
        image: "https://objetivoligar.com/wp-content/uploads/2017/03/blank-profile-picture-973460_1280-580x580.jpg",
        dni: "",
        email: "",
        telefono: "",
        password: "",
        turnosAsignados: [],
    });

    const isLogged = !!localStorage.getItem("token");

    axios.defaults.headers['authorization'] = localStorage.getItem('token');

    useEffect(() => {
        if (isLogged){
          Service.getUser()
          .then(response => {
            setUser((prevState) => ({
              ...prevState,
              id: response.data.id,
              nombreYApellido: response.data.nombreYApellido,
              dni: response.data.dni,
              email: response.data.email,
              telefono: response.data.telefono,  
              turnosAsignados: response.data.turnosAsignados,
            }));
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
            <div className='profile-container'>
                 <div className='profile-dates'>
                      <div className='image-user'>
                        <img src={user.image} className="image" alt="logo" height="144" width="140" />
                      </div>
                      <div className='dates col-lg-12 col-md-12 col-sm-12 col-xs-12'>
                        <div className='box-left col-lg-3 col-md-2 col-sm-2 col-xs-2'>
                          <p className='user-name'>{user.nombreYApellido}</p>
                          <div className='info'><p className='info-title'>DNI: </p>{user.dni}</div>
                          <div className='info'><p className='info-title'>Telefono: </p>{user.telefono}</div>
                          <div className='info'><p className='info-title'>Email: </p>{user.email}</div>
                        </div> 
                        <div className='box-right col-lg-8 col-md-8 col-sm-8 col-xs-8'>
                          <button type="button" className="button-profile" id="modal" data-toggle="modal" data-target="#exampleModalCenter">Cerrar cuenta</button>
                            <div className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                              <div className="modal-dialog modal-dialog-centered" role="document">
                                <div className="modal-content">
                                    <div className="modal-header">
                                      <p className="ask" id="exampleModalLongTitle">¿Estas seguro de cerrar tu cuenta?</p>
                                    </div>
                                    <div className="modal-body-profile">
                                      <button type="submit" className="btn-info b-profile" id='confirm'>Si, cerrar cuenta</button>
                                      <button type="button" className="btn-info b-profile" data-dismiss="modal" aria-label="Close">Cancelar</button> 
                                    </div>
                                </div>
                              </div>
                            </div>
                        </div>
                        
                      </div>
                      
                 </div>
                 <div className='profile-turnos'>
                      turnos asignados
                 </div>
            </div>
        </>  
    );
};
  
export default Profile;