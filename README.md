# Warehouse Management System

This application is a graphical application implemented in the Java programming language using the Swing library. The application allows the management of employees, products, and warehouses through an intuitive graphical user interface.

## Features

The application provides the following functionalities:
- Employee management (adding, editing, deleting, viewing).
- Product management (adding, editing, deleting, viewing).
- Warehouse management through product collections.
- Tabular display of all entities with filtering and search capabilities.
- Search for objects by all attributes, with support for value range searches.
- Saving and reading data from a text file, where all types of objects are stored in one file. Each object in the file is stored as one line, with attributes separated by a `/` character. Different types of objects are grouped into sections that start with the word `START` followed by the object type name and end with the word `END` followed by the object type name.

### Entities

- **Employee**
  - Employee ID
  - First Name
  - Last Name
  - Salary

- **Manager**
  - Inherits attributes from Employee
  - Additional attribute: Warehouse

- **Salesperson**
  - Inherits attributes from Employee
  - Additional attributes: Remarks, Workplace

- **Product**
  - Name
  - Price
  - Description
  - Category
  - Manufacturer

- **PerishableProduct**
  - Inherits attributes from Product
  - Additional attributes: Expiration Date, Packaging Type

- **HouseholdAppliance**
  - Inherits attributes from Product
  - Additional attributes: Dimensions, Color, Nominal Power

### User Interface

- **Adding and Editing Entities**: Each entity has a form tailored for data entry or editing.
- **Viewing Entities**: Entities are displayed in a tabular format with search capabilities.
- **Search**: It is possible to search for entities by all attributes. The search can be for an exact value or within a range of values.

### Saving and Reading Data

- Data can be saved in a text format in a single file.
- Each entity is stored on a single line, with attributes separated by the `/` character.
- Different types of objects are grouped into sections marked with `START` and `END` tags, defining the beginning and end of a section for a specific type of entity.

## Running the Project

### Prerequisites

- Java Development Kit (JDK) 8 or later.
- Development environment such as IntelliJ IDEA, Eclipse, or NetBeans.
