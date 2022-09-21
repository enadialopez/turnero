import React  from 'react';
import { useParams  } from "react-router-dom";

const Hospital = () => {

    const { id } = useParams();


    return (
        <>
            <div className="container">
                hola
            </div>
        </>  
    );
  }
  
  export default Hospital;