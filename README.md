Project that builds a virtual book store


Functionality so far. 
-> We are able to login based on the in-memory users 
-> We can view fictions or nonfictions books available in database
-> A new user can register
-> A user can add books in the cart

Next things to do. 
-> User need to be able to checkout the books. 




Some ISSUES needs to be fixed. 
1:  The same html file is used twice for fictions and nonfictions books rendering. It can be improved somehow to using one file for displaying
    books based on the request path. 
2: When adding and removing copies of book in the cart. Each click does the operation but the click redirect to the same page.
    This create a problem when a user wants to go back to the previous page. They need to click the previous page button the number of times that they have clicked add and remove in the same page. The user should be able to go to previous page with one click regarless of number of operation they have done in the current page. 