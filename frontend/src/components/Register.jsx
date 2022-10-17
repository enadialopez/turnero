import React, { useState } from 'react'
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
   
    return (
        <>
            <div className="register-container">
                <div className="form-register-card" > 
                    <p className="form-title">REGISTRATE EN TURNERO</p>
                    <form className='formModal'>
                        <div className='modal-inputs'>
                            <input className="form-input" type='text' name="NombreYApellido" value={data.nombreYApellido} onChange={handleChange("nombreYApellido")} placeholder="NOMBRE y APELLIDO" required  ></input>
                            <input className="form-input" type='number' name="dni" value={data.dni} onChange={handleChange("dni")} placeholder="DNI" required></input>
                            <input className="form-input" type='email' name="email" value={data.email} onChange={handleChange("email")} placeholder="EMAIL" required  ></input>
                            <input className="form-input" type='number' name="telefono" value={data.telefono} onChange={handleChange("telefono")} placeholder="TELEFONO" required  ></input>
                            <input className="form-input" type='password' name="password" value={data.password} onChange={handleChange("password")} placeholder="CONTRASEÑA" required></input> 
                        </div>
                        <button type="submit" className="btn-info b-log">REGISTRARSE</button>
                    </form>
                    <div className='modalFooter'>
                        ¿Ya sos usuario? Iniciar Sesión
                    </div>
                </div>    
            </div>
        </>
    );
  }
  
  export default Register;