# Write your MySQL query statement below
SELECT employeeUNI.unique_id, Employees.name from Employees 
LEFT JOIN EmployeeUNI ON employeeUNI.id = Employees.id;
    
