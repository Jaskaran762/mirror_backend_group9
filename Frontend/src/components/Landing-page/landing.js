import React from 'react'

import { Button } from 'react-bootstrap'

import { useNavigate } from 'react-router-dom';

import HomeNavbar from '../HomeNav';

import Footer from '../footer';

const Landing = () => {
    const changePage = useNavigate();
    const handletrip = () =>{
       changePage('/mainpage');
    }

  return (
    <div >
    <div style={{marginTop:'0px'}}>    
    <HomeNavbar/>
    </div>
        <h1>
            Landing
        </h1>
    <Button onClick={handletrip}>
        Start your trip
    </Button>

    <div style={{marginTop:'30rem'}}>
    <Footer/>
    </div>
    </div>
  )
}

export default Landing;