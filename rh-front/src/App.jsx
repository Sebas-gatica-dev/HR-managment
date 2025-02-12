import { useState } from 'react';
import ListEmployees from './employees/ListEmployees';
import Navbar from './components/Navbar';
import AddEmployee from './employees/AddEmployee';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import EditEmployee from './employees/EditEmployee';

function App() {
  return (
    <div className="d-flex flex-column min-vh-100"> {/* Flexbox + altura mínima */}
     <BrowserRouter>
     <Navbar />     
     <Routes>
      <Route exact path="/" element={<ListEmployees />} />
      <Route exact path="/add" element={<AddEmployee />} />
      <Route exact path="/edit/:id" element={<EditEmployee />} />

     </Routes>
     </BrowserRouter>
    
    </div>
  );
}

export default App;