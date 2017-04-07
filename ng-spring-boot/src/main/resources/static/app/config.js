(function () {
    'use strict';
    
     angular.module('app').
     	config(config).
     	run(['$rootScope', '$state', run]); //
     
     
     function run($rootScope, $state){ //
    	 $rootScope.$state = $state;
     }//End run

    //Config
    function config($stateProvider, $urlRouterProvider) {
    	$urlRouterProvider.otherwise("/items");
    	$stateProvider
	    	.state('items', {
	            url: "/items",
	            templateUrl: "/app/pages/items/items.view.html",
	            controller: "ItemsController as vm"
	        })
    }

})();