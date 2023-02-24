# transport-data-management-system

You must first run management-logistic-system and then transport-data-management-system.

The id-s are the selected user id.

You can see all transport data if the selected user has READ permission.

http://localhost:8080/transportData/all/{id}

You can add transport data if the selected user has ADD permission.

http://localhost:8080/transportData/add/{id}

You can modify transport data if the selected user has MODIFY permission.

http://localhost:8080/transportData/update/{id}

You can delete transport data if the selected user has DELETE permission.

http://localhost:8080/transportData/delete/{userId}/{transportDataId}
