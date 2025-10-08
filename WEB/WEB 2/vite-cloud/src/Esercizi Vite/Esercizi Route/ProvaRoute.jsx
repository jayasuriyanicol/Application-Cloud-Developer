import React, { useEffect, useState } from 'react'
import Home from './Home';
import About from './About';
import Profile from './Profile';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'

const ProvaRoute = () => {
    const [link, setLink] = useState("Home")

    const renderComponent = () => {
        if (link == "Home") {
            return <Home />
        }
        if (link == "About") {
            return <About />
        }
        if (link == "Profile") {
            return <Profile />
        }
    };

    useEffect(()=>{
        console.log("Componente Renderizzato")
    })
    return (
        <>
        <BrowserRouter>
        <nav className='navbar bg-body-tertiary'>
        <div className='container-fluid'>

            <Link to="/">Home</Link>
            <Link to="/about">About</Link>
            <Link to="/profile">Profile</Link>
        </div>

        </nav>
        <Routes>
            <Route path="/" element={<Home></Home>}></Route>
            <Route path="/about" element={<About></About>} ></Route>
            <Route path="/profile" element={<Profile></Profile>}></Route>
        </Routes>
        </BrowserRouter>
        <div>
            <nav className="navbar bg-body-tertiary">
                <div className="container-fluid">
                    <button className="btn btn-link nav-link" onClick={() => setLink("Home")} > Home </button>
                    <button className="btn btn-link nav-link" onClick={() => setLink("About")} > About </button>
                    <button className="btn btn-link nav-link" onClick={() => setLink("Profile")}> Profile </button>
                </div>
            </nav>

            <div className='container'>

          {renderComponent()}
            </div>
        
        </div>
        </>
    );
};

export default ProvaRoute;