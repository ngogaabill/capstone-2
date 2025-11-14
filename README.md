# 🌮 Taco Galaxy
<img src="images/TacoLogo.png" alt="Taco Galaxy Logo" width="100" height="auto"/>

Taco Galaxy is a Java-based console ordering application that allows users to build customized tacos, street tacos, drinks, chips & salsa.  
It features premium toppings, sauces, deep-fry options, and a full checkout summary with receipt generation.

---
## 🚀 Features

### ✔ Interactive Console Menu
Users can:
- Create new orders
- Add tacos or street tacos
- Add drinks
- Add chips & salsa
- Fully customize tacos (meats, cheese, sauces, toppings, sides, deep fry)
- View an order summary
- Generate a receipt

---

## 🖥 Application Screenshots

### **Main Menu**
![Main Menu](images/Main.png)

### **Street Taco Screen**
![Street Taco](images/street.png)

### **Order Summary**
![Order Summary](images/summary.png)

---

## 🏗 Project Structure
<img src="images/A UML class diagram .png" alt="Taco Galaxy UML Diagram" width="600"/>

        if (meatToRemove != null) {
            toppings.remove(meatToRemove);
            streetTaco.addToppingPrice(-meatToRemove.getPrice()); //Add neg amount of the meat to didact from order price
            System.out.println("✓ Removed: " + meatToRemove.getName());
        }
This was my favorite piece of code because I neutralized the total by adding the negative value.