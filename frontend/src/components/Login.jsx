import React, { useState } from 'react'
import { AiOutlineCloseCircle }from 'react-icons/ai';
import { useContext } from 'react';
import { Context } from './Contexto';
import '../styles/Login.css'

const Login = () => {

  const [contextState, setContextState] = useContext(Context);
  const [data, setData] = useState({
    dni: "",
    password: ""
  });

  const [loginError, setLoginError] = useState (false);
  const [loginErrorName, setLoginErrorName] = useState("");

  const handleChange = name => event => {
    setData(prevState => ({ ...prevState, [name]: event.target.value }));
  };

  const handleSubmit = (event) =>{
    event.preventDefault();
    
  }

  return ( 
    <>
      <div className='modalContainer' style={{ pointerEvents: contextState  ? 'auto' : 'auto',}}>
        <div className='modalHeader'>
          <p className="modal-title" id="exampleModalLongTitle">INICIAR SESIÓN</p>
          <AiOutlineCloseCircle onClick={() => {setContextState({ bool: false, message: "" })}} className='btn-close'/>   
        </div>
        <div className='modalForm'>
          {loginError && (<div className="alert alert-danger" role="alert">{loginErrorName}</div>) }
          <form className='formModal' onSubmit={handleSubmit}>
            <div className='modal-inputs'>
                <input className="form-input" type='text' name="dni" value={data.dni} onChange={handleChange("dni")} placeholder="DNI" required  ></input>
                <input className="form-input" type='password' name="password" value={data.password} onChange={handleChange("password")} placeholder="CONTRASEÑA" required></input> 
            </div>
            <button type="submit" className="btn-info b-log">INICIAR SESIÓN</button>
          </form>
        </div>
        <div className='modalFooter'>
            ¿Todavia no sos usuario? Registrate
        </div>
      </div>
    </>
  )
}
export default Login;