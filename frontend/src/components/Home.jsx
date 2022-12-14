import React, { useState }  from 'react';
import { useNavigate } from 'react-router-dom';
import { AiOutlineSearch } from "react-icons/ai";
import Navbar from '../components/Navbar';
import '../styles/Home.css';

const Home = () => {

    const [selection, setSelection] = useState(""); 
    const [search, setSearch] = useState("");
    const [showAlert, setShowAlert] = useState (false)
    const changeSearch = (event) => setSearch(event.target.value);
    const navigate = useNavigate();

    const changeSelectValue = (value) => {
        setSelection(value)
        setShowAlert(false)
    }

    const goSearchResults = () => {
        navigate("/hospital/search?q=" + search + "&value=" + selection) ;
    };

    const handleButtonClick = () => {
        if (selection === "") {
            setShowAlert(true)
        } else {
            goSearchResults()
        }
    }

    return (
        <>
            <div className="navbar">
                <Navbar/>
            </div> 
            <div className="home-container">
                <div className='text-1'>
                    <p>BUSCAR PARA SACAR TURNO</p> 
                </div>
                <div className="search-content">  
                    <div className='search-bar'>
                        <div className='message-error'>
                            { showAlert ? <div className="alert alert-success" role="alert">Debe seleccionar una opción para realizar la busqueda</div> : ""}
                        </div>
                        <div className='box-search'>
                            <input className="search-btn" type="text" placeholder="Buscar hospital" aria-label="Search" onChange={changeSearch} />
                            <button onClick={() => handleButtonClick(search, selection)} className="btn btn-secondary" type="submit"><AiOutlineSearch color="white" size={25}/></button>
                        </div>
                    </div>
                    <div className='text-2'>
                        
                    </div>
                    <div className='search-checkbox'>
                        <input type="radio" className="radio" name="1" onClick={ () => changeSelectValue("nombre")} required/><label className='checkbox'>Nombre</label>
                        <input type="radio" className="radio" name="1" onClick={ () => changeSelectValue("municipio")} required/><label className='checkbox'>Municipio</label>
                        <input type="radio" className="radio" name="1" onClick={ () => changeSelectValue("especialidad")} required/><label className='checkbox'>Especialidad</label>
                    </div>
                </div>
            </div>
        </>  
    );
  }
  
  export default Home;