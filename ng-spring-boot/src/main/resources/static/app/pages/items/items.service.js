(function () {
    'use strict';

    angular
        .module('app')
        .factory('ItemsService', ItemsService);

    ItemsService.$inject = ['$http', '$resource'];
    function ItemsService($http, $resource) {
    	var service = {};
        service.getAll = getAll;
        service.add = create;
        service.update = update;
        service.remove = remove;
        return service;

        function getAll() {
            return $http.get('/items/').then(onSuccess, onFailure);
        }
        
        function create(item, id) {
        	return $http.post('/items/', item).then(onSuccess, onFailure);   
        }

        function update(item, id) {
        	return $http.put('/items/'+id, item).then(onSuccess, onFailure);   
        }

        function remove(id) {
        	return $http.delete('/items/'+id).then(onSuccess, onFailure);  
        }

        // private functions
        function onSuccess(result) {           
        	return result.data;
        }

        function onFailure(error) {
            throw error.data;
        }
    }

})();
