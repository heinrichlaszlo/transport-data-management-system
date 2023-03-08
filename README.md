# transport-data-management-system

You must first run https://github.com/heinrichlaszlo/management-logistic-system and then https://github.com/heinrichlaszlo/transport-data-management-system.

Firstly you have to login.

http://localhost:8080/transportData/login/name/password

You can see all transport data if the logged user the selected user has READ permission.

http://localhost:8080/transportData/all

You can add transport data if the logged userr has ADD permission.

http://localhost:8080/transportData/add

You can modify transport data if the logged user has MODIFY permission.

http://localhost:8080/transportData/update

You can delete transport data if the logged user has DELETE permission.

http://localhost:8080/transportData/delete/{transportDataId}

and the logout:

http://localhost:8080/transportData/logout
