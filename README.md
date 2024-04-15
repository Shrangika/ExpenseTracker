# ExpenseTracker
Welcome to the ExpenseTracker repository!This repository houses a set of APIs designed to facilitate CRUD (Create, Read, Update, Delete) operations on expenses and categories.The core functionality revolves around two main tables: one for adding categories and the other for adding expenses under those categories.

# Technologies Used
# Java: 
Core programming language for backend development.

# Spring Boot: 
Framework for building robust and scalable Java applications.
Port Number-8080

# Hibernate:
Object-relational mapping library for data persistence.

# MySQL:
Relational database management system for storing account information and transaction records.
Port Number:3306

# Maven:
Dependency management tool for Springboot projects.

# API Endpoints
# PostMapping(/api/categories): 
To create new category
# GetMapping(/api/categories/{id})
To get category with the given categoryId
# PutMapping(/api/categories/{id})
To update the category name of the given categoryId
# GetMapping(/api/categories)
To get all categories present in database
# DeleteMapping(/api/categories/{id})
To delete the category with given categoryId
# PostMapping(/api/expenses): 
To create new expense
# GetMapping(/api/expenses/{id})
To get expense with the given expenseId
# PutMapping(/api/expenses/{id})
To update the expense with given expenseId
# GetMapping(/api/expenses)
To get all expenses present in database
# DeleteMapping(/api/expenses/{id})
To delete the expense with given expenseId
