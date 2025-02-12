import axios from 'axios';
import {React, useEffect ,useState} from 'react'
import { NumericFormat } from 'react-number-format';
import {  Link } from 'react-router-dom';




function ListEmployees() {


    
    const urlBase = "http://localhost:8080/rh-api/employees";
    const [employees, setEmployees] = useState([]);


    useEffect(() => {
        loadEmployees();
    },[]);


    const loadEmployees = async () => {
     const response = await axios.get(urlBase).then((response) => {
            setEmployees(response.data);
          
        });

    }
    

    const deleteEmployee = async (id) => {
        await axios.delete(`${urlBase}/${id}`);
        loadEmployees();
    }
    

    


  return (
    <div className="flex-grow-1">
    <div className="container-fluid p-4">
      <div className="container text-center" style={{ margin: "30px" }}>
        <h1>Employees</h1>

      </div>
    <table className="table table-striped table-hover align-middle">
      <thead className="table-dark">
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Salary</th>
          <th scope="col">Departament</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>

          {
            employees.map((employee, index) => (
              <tr key={index}>
                  <td>{employee.name}</td>
                  <td>
                      <NumericFormat 
                          value={employee.salary}
                          displayType={'text'}
                          thousandSeparator=',' prefix={'$'}
                          decimalScale={2} fixedeDecimalScale="true"
                      /> 
                  </td>
                  <td>{employee.departament}</td>
                  <td className="text-center">
                    <Link 
                      to={`/edit/${employee.idEmployee}`}
                      className="btn btn-warning btn-sm me-3"
                    >Edit</Link>
                    <button onClick={() => deleteEmployee(employee.idEmployee)} className="btn btn-danger btn-sm" >
                      Delete
                    </button>
                  </td>
            </tr>
            )) 
          }
      </tbody>
    </table>
  </div>  
  </div>
  
  )
}

export default ListEmployees;