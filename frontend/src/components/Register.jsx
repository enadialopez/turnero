import React, { useState } from 'react'
import { AiOutlineCloseCircle }from 'react-icons/ai';
import { useNavigate } from 'react-router-dom';
import '../styles/Register.css';

const Register = () => {

    const [data, setData] = useState({
        nombreYApellido: "",
        dni: "",
        email: "",
        telefono: "",
        password: "",
      });

    const handleChange = name => event => {
    setData(prevState => ({ ...prevState, [name]: event.target.value }));
    };
   
    const navigate = useNavigate();

    const goHome = () => {
        navigate("/") ;
    };
    return (
        <>
            <div className="register-container">
                <div className="form-register-card" > 
                    <div className="btn-close" onClick={() => goHome()} > 
                        <AiOutlineCloseCircle/>  
                    </div>
                    <p className="form-title">REGISTRATE EN TURNERO</p>
                    
                    <form className='formModal'>
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
                        ¿Ya sos usuario? Iniciar Sesión
                    </div>
                </div>    
            </div>
        </>
    );
  }
  
  export default Register;