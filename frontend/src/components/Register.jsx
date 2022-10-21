import React, { useState } from 'react'
import { AiOutlineCloseCircle }from 'react-icons/ai';
import { useNavigate } from 'react-router-dom';
import Service from '../service/service';
import axios from 'axios';
import '../styles/Register.css';

const Register = () => {

    const [data, setData] = useState({
        nombreYApellido: "",
        dni: "",
        email: "",
        telefono: "",
        password: "",
      });

    const [registerError, setRegisterError] = useState (false)

    const handleChange = name => event => {
        setData(prevState => ({ ...prevState, [name]: event.target.value }));
    };

    axios.defaults.headers['authorization'] = localStorage.getItem('token');
   
    const handleSubmit = (event) =>{
        event.preventDefault(); 
        Service.postRegister(data)
        .then(response => {
            console.log(response)
            //localStorage.setItem("token",response.headers.authorization)
            navigate("/");
          })
          .catch(err => console.log(err));
      }
    

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
                        <div className='modal-inputs'>
                            <input className="form-input" type='text' name="NombreYApellido" value={data.nombreYApellido} onChange={handleChange("nombreYApellido")} placeholder="Nombre y Apellido" required  ></input>
                            <input className="form-input" type='text' name="dni" value={data.dni} onChange={handleChange("dni")} placeholder="DNI" required></input>
                            <input className="form-input" type='email' name="email" value={data.email} onChange={handleChange("email")} placeholder="Email" required  ></input>
                            <input className="form-input" type='text' name="telefono" value={data.telefono} onChange={handleChange("telefono")} placeholder="Telefono" required  ></input>
                            <input className="form-input" type='password' name="password" value={data.password} onChange={handleChange("password")} placeholder="Contraseña" required></input> 
                        </div>
                        <button type="submit" className="btn-info b-log">REGISTRARSE</button>
                    </form>
                    <div className='modalFooter-register'>
                        
                    </div>
                </div>    
            </div>
        </>
    );
  }
  
  export default Register;