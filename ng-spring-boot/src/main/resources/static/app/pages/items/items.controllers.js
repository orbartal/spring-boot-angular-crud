(function () {
    'use strict';

    angular
        .module('app')
        .controller('ItemsController', ItemsController);
    
    ItemsController.$inject = ['ItemsService'];
    
    function ItemsController (ItemsService) {
        var vm = this;
        vm.items =[];
        vm.newItem = {};
        vm.newItem.name = "new name";
        
        
        
        vm.addItem = function() {
        	debugger;
        	ItemsService.add(vm.newItem).then(onSuccess, onFailure);
        	
        	function onSuccess(data) {           
        		vm.getAll ();
        		vm.newItem.name = "";
            }

            function onFailure(error) {
                debugger;
            }
        }

        vm.getAll = function() {
        	 ItemsService.getAll().then(onSuccess, onFailure);
        	
        	 function onSuccess(data) {           
        		 vm.items = data;
             }

             function onFailure(error) {
                debugger;
             }
        }
       
        
        vm.updateItem = function  (item) {
        	ItemsService.update(vm.newItem, item.id).then(onSuccess, onFailure);
        	
        	function onSuccess(data) {           
        		vm.getAll ();
            }

            function onFailure(error) {
                debugger;
            }
        }
        
        vm.deleteItem = function (item) {
        	ItemsService.remove(item.id).then(onSuccess, onFailure);
        	
        	function onSuccess(data) {           
        		vm.getAll ();
            }

            function onFailure(error) {
                debugger;
            }
       }
        
       vm.getAll();
    }
})();