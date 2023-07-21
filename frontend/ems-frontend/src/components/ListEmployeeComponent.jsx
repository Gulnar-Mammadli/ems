import React, {useState} from 'react'
import { useEffect } from 'react';
import { deleteEmployee, listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {
  
    const [employees, setEmployyes] = useState([]);

    const navigator = useNavigate();

    useEffect(()=>{
      getAllEmployees();
    },[])

    function getAllEmployees(){

        listEmployees().then((response)=>{
            setEmployyes(response.data);
           }).catch((error)=>{
            console.log(error);
           })
    }
    function AddEmployee(){
        navigator('/add-employee');
    }

    function updateEmployee(id){
        navigator(`/edit-employee/${id}`);
    }

    function removeEmployee(id){
        deleteEmployee(id).then((response)=>{
        console.log(response.data);
        getAllEmployees();
        }).catch((error)=>{
            console.log(error);
        })
    }
    
  return (
    <div className="container">
        <h2 className='text-center'>List of Employees</h2>
        <table className='table table-striped table-bordered'>
            <thead className="thead-dark">
                <tr>
                    <th>#</th>
                    <th> First Name</th>
                    <th> Last Name</th>
                    <th> Email</th>
                    <th>Active</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
               { 
               employees.map((employee,rowId) =>
               <tr key={rowId}>
                <td>{rowId+1}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.active.toString()}</td>
                <td>
                    <button className='btn btn-info' onClick={()=>updateEmployee(employee.id)}>Update</button>
                    <button className='btn btn-danger' onClick={()=>removeEmployee(employee.id)}>Delete</button>
                
                </td>
                </tr>)
                }
            </tbody>
        </table>
        <button className="btn btn-primary mb-2" onClick={AddEmployee} >Add Employee</button>
    </div>
  )
}

export default ListEmployeeComponent