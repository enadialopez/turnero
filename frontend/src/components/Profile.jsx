import React, { useState, useEffect }  from 'react'
import { useNavigate } from "react-router-dom"
import Navbar from '../components/Navbar'
import Service from '../service/service'
import TurnoModel from './TurnoModel'
import {Modal, TextField, Button} from '@material-ui/core';
import {makeStyles} from '@material-ui/core/styles';
import axios from 'axios'
import '../styles/Profile.css'

const Profile = () => {

    const [user, setUser] = useState({
        id: "",
        nombreYApellido: "",
        image: "https://objetivoligar.com/wp-content/uploads/2017/03/blank-profile-picture-973460_1280-580x580.jpg",
        dni: "",
        email: "",
        telefono: "",
        password: "",
    })
    const [turnos, setTurnos] = useState([]);
    const navigate = useNavigate();
    const isLogged = !!localStorage.getItem("token");

    axios.defaults.headers['authorization'] = localStorage.getItem('token');

    const styles = useStyles();

    const [modal, setModal]=useState(false);
    const abrirCerrarModal=()=> {
      setModal(!modal)
    }

    const handleChange = name => event => {
      setUser(prevState => ({ ...prevState, [name]: event.target.value }));
  };

  const handleSub = (event) => {
    handleSubmit(event)
    abrirCerrarModal()
  }

  const handleSubmit = (event) =>{
    event.preventDefault(); 
    Service.putActualizarPerfil(user.id)
    
  };

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

    useEffect(() => {
      if (isLogged) {
        Service.getTurnosAsignadosBy(user.dni)
        .then(response => {
          setTurnos(response.data)
        })
        .catch(error => {
          console.log(error)
      })}}, [user.dni]
  );  

    const deleteAccount = () => {
      Service.deleteUser(user.id)
      .then( _ => {
        localStorage.removeItem("token");  
        navigate("/")
        window.location.reload();  
      }).catch(error => {
        console.log(error)
      });
  };

  const body=(
    <div className={styles.modal}>
      <div align="center">
        <h2>Editar perfil</h2>
      </div>
      <TextField label= "Nombre y Apellido" className = {styles.modalInputs} value={user.nombreYApellido} onChange={handleChange("nombreYApellido")} />
      <br/> <br/>
      <TextField label= "Image" className = {styles.modalInputs} value={user.image} onChange={handleChange("imagen")} />
      <br/> <br/>
      <TextField label= "Email" className = {styles.modalInputs} value={user.email} onChange={handleChange("email")} />
      <br/> <br/>
      <TextField label= "Telefono" className = {styles.modalInputs} value={user.telefono} onChange={handleChange("telefono")} />
      <br/> <br/>
      <TextField label= "Contraseña" className = {styles.modalInputs} value={user.password} onChange={handleChange("password")} />
      <br/> <br/>
      <div align="right">
        <Button onClick={handleSub} className={styles.buttonProfile} >Aceptar</Button>
        <Button onClick={()=>abrirCerrarModal()} className={styles.buttonProfile} >Cancelar</Button>
      </div>
    </div>
  )

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
                          <div className={styles.button}>
                            <Button className={styles.buttonProfile} onClick={()=>abrirCerrarModal()} >Editar perfil</Button>
                              <Modal
                                open={modal}
                                onClose={abrirCerrarModal}>
                                    {body}
                                    </Modal>
                                    </div>
                          <button type="button" className="button-profile" id="modal" data-toggle="modal" data-target="#exampleModalCenter">Cerrar cuenta</button>
                            <div className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                              <div className="modal-dialog modal-dialog-centered" role="document">
                                <div className="modal-content">
                                    <div className="modal-header">
                                      <p className="ask" id="exampleModalLongTitle">¿Estas segura/o de cerrar tu cuenta?</p>

                                    </div>
                                  
                                    <div className="modal-body-profile">
                                    Si dá de baja su cuenta, los turnos asignados vuelven a estar como diponibles
                                      <button className="btn-info b-profile" id='confirm' onClick={() => deleteAccount()}>Si, cerrar cuenta</button>
                                      <button className="btn-info b-profile" data-dismiss="modal" aria-label="Close">Cancelar</button> 
                                    </div>
                                </div>
                              </div>
                            </div>
                        </div>  
                      </div>
                 </div>
                 <div className='profile-turnos'>
                     <h4>Mis turnos:</h4>
                     {turnos.map((turno, idx) => {          
                        return <TurnoModel key={turno.id} turno={turno}/>
                    })}
                 </div>
            </div>
        </>  
    );
};
  
export default Profile;

const useStyles = makeStyles((theme)=>({
  modal: {
    position:'absolute',
    width: 400,
    backgroundColor: 'white',
    borderRadius: '5px',
    boxShadow: theme.shadows[5],
    padding: "16px 32px 24px",
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    borderStyle: 'double',
    borderColor: 'gainsboro'
  },

  buttonProfile: {
    color: 'white',
    width: "100px",
    height: "30px",
    margin: "15px",
    fontSize: "10px",
    fontWeight: 500,
    borderRadius: "10px",
    backgroundColor:'rgb(21, 16, 103)',
    gap: "20px",
    '&:hover': {
      borderColor:'rgb(55, 55, 55)',
      backgroundColor:'rgb(21, 16, 103)',
    }
  },

  modalInputs: {
    justifyContent: 'left',
    textAlign: 'left',
    color: 'rgb(0, 0, 0)',
    fontWeight: 700,
    margin: "0px",
},
}))