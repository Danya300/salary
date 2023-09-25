package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etName, etSalary;
    private Button btnAdd, btnShow;
    private TextView tvResult;
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private List<com.example.myapplication.Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etSalary = findViewById(R.id.etSalary);
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        tvResult = findViewById(R.id.tvResult);
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the list of employees
        employeeList = new ArrayList<>();

        // Initialize the RecyclerView and its adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EmployeeAdapter(employeeList);
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add a new employee to the list
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String salary = etSalary.getText().toString();
                Employee employee = new Employee(id, name, salary);
                employeeList.add(employee);
                adapter.notifyDataSetChanged();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display the list of employees in the TextView
                StringBuilder result = new StringBuilder("Employees:\n");
                for (Employee employee : employeeList) {
                    result.append("ID: ").append(employee.getId()).append(", Name: ").append(employee.getName()).append(", Salary: ").append(employee.getSalary()).append("\n");
                }
                tvResult.setText(result.toString());
            }
        });
    }
}
