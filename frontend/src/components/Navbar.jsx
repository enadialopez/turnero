import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";
import Service from '../service/service';
import logo from '../logo.png';
import axios from 'axios';
import '../styles/Navbar.css';

const Navbar = () => {

    const [data, setData] = useState({
        email: "",
        password: ""
    });
    const [loginError, setLoginError] = useState (false);
    const [loginErrorName, setLoginErrorName] = useState("");
    const isLogged = !!localStorage.getItem("token");

    const handleChange = name => event => {
        setData(prevState => ({ ...prevState, [name]: event.target.value }));
    };
    
    const handleSubmit = (event) => {
        event.preventDefault();
        Service.postLogin(data)
        .then(response => {
            console.log(response)
            localStorage.setItem("token", response.data.token);
            window.location.reload();  
          })
        .catch(err => {
            setLoginError(true)
            setLoginErrorName(err.response.data.message);  
        })
    };  

    const logout = () => {
        localStorage.removeItem("userData");
        localStorage.removeItem("token");
    };

    const buttonsLogueado = () => {
        return(
            <>
                <div className="buttons-content">
                    <a className="button-nb" href={`/`} id="btn"> INICIO </a>
                    <a className="button-nb" href={`/profile`} id="btn"> PERFIL </a>
                    <a className="button-nb" href={"/"} onClick={() => logout()}  id="btn"> CERRAR SESIÓN</a>
                </div>
            </>
        )
    };

    axios.defaults.headers['authorization'] = localStorage.getItem('token');
      
    const buttonsSinLoguearse = () => {
        return(
          <>
            <a className="button-nb" href={`/`} id="btn"> INICIO </a>
            <a className="button-nb" href="/register">REGISTRARSE</a>
          </>  
        )
    };

    const Buttons =  !!localStorage.getItem("token")  ? buttonsLogueado : buttonsSinLoguearse;  

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
                    <Buttons/>
                    <div>
                        { !isLogged 
                        ?
                        <>
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
                                                <form className='formModal' onSubmit={handleSubmit}>
                                                    <div className='modal-inputs'>
                                                        <input className="form-input" type='text' name="email" value={data.email} onChange={handleChange("email")} placeholder="Email" required  ></input>
                                                        <input className="form-input" type='password' name="password" value={data.password} onChange={handleChange("password")} placeholder="Contraseña" required></input> 
                                                    </div>
                                                    {loginError && (<div id='alert-login' className="alert alert-danger" role="alert">{loginErrorName}</div>) }
                                            
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
                        </>    
                        :
                            <div></div>
                        }
                    </div>
                </div>  
            </div>
        </>
    );
  }
  
  export default Navbar;