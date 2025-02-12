import {React, useState, useEffect} from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';


export default function EditEmployee() {

    const url = "http://localhost:8080/rh-api/employees";
    let navigate = useNavigate();

    const { id } = useParams();

    const [employee, setEmployee] = useState({
        name:"",
        departament:"",
        salary:""
    })

    const {name, departament, salary} = employee;


    useEffect(()=>{
        loadEmployee();
    },[]);

    const loadEmployee = async () => {
        const response = await axios.get(`${url}/${id}`);
        setEmployee(response.data);
    }


    const onInputChange = (e) => {
        //spread operator para expandir los atributos
        setEmployee({...employee, [e.target.name]: e.target.value})
    }


    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`${url}/${id}`, employee);
        navigate('/');
    }

  return (
    <div className="container-fluid">
        <div className="container">
            <div className="container text-center" style={{ margin: "30px"}}>
                <h3>Edit Employee</h3>
            </div>

            <form onSubmit={(e)=> onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="exampleInputEmail1" className="form-label">Name</label>
                    <input 
                        type="text" 
                        className="form-control" 
                        id="exampleInputEmail1" 
                        aria-describedby="emailHelp"
                        name="name"
                        value={name}
                        onChange={(e) => onInputChange(e)}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleInputPassword1" className="form-label">Departament</label>
                    <input 
                        type="text" 
                        className="form-control" 
                        id="exampleInputPassword1"
                        name="departament"
                        value={departament}
                        onChange={(e) => onInputChange(e)}
                    />
                </div>
                <div className="mb-3 ">
                    <label className="form-label" htmlFor="exampleCheck1">Salary</label>
                    <input 
                        type="number" 
                        step="any" 
                        className="form-control" 
                        id="exampleCheck1"
                        name="salary"
                        min={0}
                        value={salary}
                        onChange={(e) => onInputChange(e)}
                                                
                    />
                </div>

                <div className="text-center">
                    <button type="submit" className="btn btn-warning btn-sm me-3 " >Save</button>
                    <Link className="btn btn-danger btn-sm" to="/">Back</Link>
                </div>

                </form>


                

        </div>
    </div>
  )
}
