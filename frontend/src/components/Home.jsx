import React, { useState }  from 'react';
import { Link } from 'react-router-dom';
import { AiOutlineSearch } from "react-icons/ai";
import '../styles/Home.css';

const Home = () => {

    const [selection, setSelection] = useState(""); 
    const [search, setSearch] = useState("");
    const changeSearch = (event) => setSearch(event.target.value);
    const [searchError, setSearchError] = useState (false)

    const changeSelectValue = (value) => {
         setSelection(value);
         setSearchError(true);
    }

    return (
        <>
            <div className="home-container">
                <div className='text-1'>
                    <p>BUSCAR PARA SACAR TURNO</p> 
                </div>
                <div className="search-content">  
                    <div className='search-bar'>
                        <input className="search-btn" type="text" placeholder="Buscar hospital" aria-label="Search" onChange={changeSearch} />
                        <Link to={`/hospital/search?q=${search}&value=${selection}`}>
                            <button className="btn btn-secondary" type="submit" ><AiOutlineSearch color="white" size={20}/></button>
                        </Link>
                    </div>
                    <div className='text-2'>
                        
                    </div>
                    <div className='search-checkbox'>
                        <input type="radio" className="radio" name="1" onClick={ () => changeSelectValue("nombre")}/><label className='checkbox'>Nombre</label>
                        <input type="radio" className="radio" name="1" onClick={ () => changeSelectValue("municipio")}/><label className='checkbox'>Municipio</label>
                        <input type="radio" className="radio" name="1" onClick={ () => changeSelectValue("especialidad")}/><label className='checkbox'>Especialidad</label>
                    </div>
                </div>
            </div>
        </>  
    );
  }
  
  export default Home;