import React, { useState } from 'react'
import { AiOutlineCloseCircle }from 'react-icons/ai';
import { useNavigate } from 'react-router-dom';
import Service from '../service/service';
import axios from 'axios';
import '../styles/Register.css';

const Register = () => {

    const [data, setData] = useState({
        nombreYApellido: "",
        image: "",
        dni: "",
        email: "",
        telefono: "",
        password: "",
        turnosAsignados: []
      });

    const [registerError, setRegisterError] = useState (false);
    const [registerErrorName, setRegisterErrorName] = useState("");

    const handleChange = name => event => {
        setData(prevState => ({ ...prevState, [name]: event.target.value }));
    };

    axios.defaults.headers['authorization'] = localStorage.getItem('token');
   
    const handleSubmit = (event) =>{
        event.preventDefault(); 
        Service.postRegister(data)
        .then(response => {
            localStorage.setItem("token", response.data.token);
            navigate("/");
          })
          .catch(err => {
            setRegisterError(true)
            setRegisterErrorName(err.response.data.message);  
        })
    };
    
    const navigate = useNavigate();

    const goHome = () => {
        navigate("/") ;
    };

    console.log(data)

    return (
        <>
            <div className="register-container">
                <div className="form-register-card" > 
                    <div className="btn-close" onClick={() => goHome()} > 
                        <AiOutlineCloseCircle/>  
                    </div>
                    <p className="form-title">REGISTRATE EN TURNERO</p>
                    <form className='formModal' onSubmit={handleSubmit}>
                        <div className='modal-inputs-register'>
                            <label>Nombre y Apellido(*)</label>
                            <input className="form-input" type='text' name="NombreYApellido" value={data.nombreYApellido} onChange={handleChange("nombreYApellido")} placeholder="Roberto Gomez" required></input>
                            <label>Imagen</label>
                            <input className="form-input" type='text' name="image" value={data.image} onChange={handleChange("image")} placeholder="https://example.es/slide.jpg"></input>
                            <label>DNI(*)</label>
                            <input className="form-input" type='text' name="dni" value={data.dni} onChange={handleChange("dni")} placeholder="20345678" required></input>
                            <label>Email(*)</label>
                            <input className="form-input" type='email' name="email" value={data.email} onChange={handleChange("email")} placeholder="example@gmail.com" required></input>
                            <label className='label'>Telefono</label>
                            <input className="form-input" type='text' name="telefono" value={data.telefono} onChange={handleChange("telefono")} placeholder=" 1122334455"></input>
                            <label>Contraseña(*)</label>
                            <input className="form-input" type='password' name="password" value={data.password} onChange={handleChange("password")} placeholder="Debe contener al menos 8 caracteres" required></input> 
                        </div>
                        {registerError && (<div id='alert-register' className="alert alert-danger" role="alert">{registerErrorName}</div>) }
                        <button type="submit" className="btn-info b-register">REGISTRARSE</button>
                    </form>
                    <div className='modalFooter-register'>
                    </div>
                </div>    
            </div>
        </>
    );
  }
  
  export default Register;