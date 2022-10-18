import React, { useState } from 'react'
import { useContext } from 'react'
import { Context } from './Contexto';
import logo from '../logo.png';
import '../styles/Navbar.css';

const Navbar = () => {

    const [dataLogin, setDataLogin] = useState({
        email: "",
        password: ""
      });

    const handleChange = name => event => {
        setDataLogin(prevState => ({ ...prevState, [name]: event.target.value }));
    };
   
    return (
        <>
            <div className="navbar-container">
                <div className="col-lg-4 col-md-4 col-sm-5 col-xs-6 nav-left">
                </div>
                <div className="col-lg-4 col-md-4 col-sm-1 col-xs-0 nav-medium">
                    <div className="logo-content">
                        <a title="logo" href="/"><img src={logo} alt="logo" height="130" width="130" /></a>
                    </div>
                </div>
                <div className="col-lg-4 col-md-4 col-sm-6 col-xs-6 nav-right">
                    <a className="button-nb" href="/register">REGISTRARSE</a>
                    <a type="button" className="button-nb" id="modal" data-toggle="modal" data-target="#exampleModalCenter">INICIAR SESIÓN</a>
                    <div className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div className="modal-dialog modal-dialog-centered" role="document">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <p className="modal-title" id="exampleModalLongTitle">INICIAR SESIÓN</p>
                                    <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div className="modal-body">
                                    <div className='modalForm'>
                                        <form className='formModal'>
                                            <div className='modal-inputs'>
                                                <input className="form-input" type='text' name="email" value={dataLogin.email} onChange={handleChange("email")} placeholder="DNI" required  ></input>
                                                <input className="form-input" type='password' name="password" value={dataLogin.password} onChange={handleChange("password")} placeholder="Contraseña" required></input> 
                                            </div>
                                            <button type="submit" className="btn-info b-log">INICIAR SESIÓN</button>
                                        </form>
                                    </div>
                                    <div className='modalFooter-login'>
                                        ¿Todavia no sos usuario? <a className="button-nb" href="/register">Registrarse</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>  
            </div>
        </>
    );
  }
  
  export default Navbar;


  /*
  <a type="button" className="button-nb" id="modal" data-toggle="modal" data-target="#exampleModalCenter">REGISTRARSE</a>
    <div className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div className="modal-dialog modal-dialog-centered" role="document">
            <div className="modal-content">
                <div className="modal-header">
                    <p className="modal-title-register" id="exampleModalLongTitle"> REGISTRATE EN TURNERO </p>
                    <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div className="modal-body">
                    <div className='modalForm'>
                        <form className='formModal'>
                            <div className='modal-inputs'>
                                <input className="form-input-register" type='text' name="NombreYApellido" value={dataRegister.nombreYApellido} onChange={handleChange("nombreYApellido")} placeholder="NOMBRE Y APELLIDO" required  ></input>
                                <input className="form-input-register" type='text' name="dni" value={dataRegister.dni} onChange={handleChange("dni")} placeholder="DNI" required></input>
                                <input className="form-input-register" type='email' name="email" value={dataRegister.email} onChange={handleChange("email")} placeholder="EMAIL" required  ></input>
                                <input className="form-input-register" type='text' name="telefono" value={dataRegister.telefono} onChange={handleChange("telefono")} placeholder="TELEFONO" required  ></input>
                                <input className="form-input-register" type='password' name="password" value={dataRegister.password} onChange={handleChange("password")} placeholder="CONTRASEÑA" required></input> 
                            </div>
                            <button type="submit" className="btn-info b-log">REGISTRATE</button>
                        </form>
                    </div>
                    <div className='modalFooter'>
                        ¿Todavia no sos usuario? Registrate
                    </div>
                </div>
            </div>
        </div>
  */