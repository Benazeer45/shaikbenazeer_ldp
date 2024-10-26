//Question-1
// Refactor the following function into a one-liner:
// const printName = (name) => {
//            return “Hi” + name;
//      }
//answer
const printName = (name) => "Hi " + name;
console.log(printName("Benny")); // Output: Hi Alice


//Question-2
// Rewrite the following code using template literals
// const printBill = (name, bill) => {
//               return “Hi “ + name + “, please pay: “ + bill;
//        }
//answer
const printBill = (name, bill) => `Hi ${name}, please pay: ${bill}`;
console.log(printBill("Benny",300));  //Hi Benny, please pay: 300


//Question-3
// Modify the following code such that the object properties are destructured and logged.
// const person = {
//                       name: “Noam Chomsky”,
//                       age: 92
//             }
           
//            let name = person.name;
//            let age = person.age;
//            console.log(name);
//            console.log(age);
//Answer
const person = {
  name1: "Benny",
  age: 21
};
const { name1, age } = person;
console.log(name1);
console.log(age);

