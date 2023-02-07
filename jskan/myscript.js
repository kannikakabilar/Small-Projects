function myFunction2() {
  document.getElementById("demo5").innerHTML = "Paragraph changed 2.";
}

// Statements in JavaScripts
let a, b, c;  // Declare 3 variables
a = 9;        // Assign the value 9 to a
b = 4;        // Assign the value 4 to b
c = a + b;    // Assign the sum of a and b to c
console.log(c)  // c = 13

/* If you put a number in quotes, the rest of the numbers will be treated as strings, and concatenated. */
let x = 4 + 3 + "5";
console.log(x)   // x = (4+3) + "5" = 7+"5" = 75

// Variables defined with let cannot be redeclared.
let y = "Kannika";
// let y = 0; // SyntaxError: 'x' has already been declared
// But using var, variables can be redeclared
var w = "Kannika";
var w = 0;
