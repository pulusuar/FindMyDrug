# FindMyDrug
This is an android application to find the availability of the medicines in the medical stores. 

When the user logs in into the application and searches for a particular medicine, 
the application displays the list of stores with the availability of that medicine. 
When the user clicks on the selected store, 
the application displays the location of the store and the user on the maps and the path to reach the store from the user location. 

On the store side, if the store user wants to add his store to the application, 
he should request the admin by sending the request through the application. 
When the admin processes this request, he will add the store and send the login details to the store user through email.
Store uses are responsible for maintaining the list of medicines in the store and updating them regularly.

Admin is responsible for maintaining the list of stores on the application.
He can also send notification to the store users when the new medicine or formula is available in the market.
To send notification, we use the concept of GCM(Google Cloud Messaging).
