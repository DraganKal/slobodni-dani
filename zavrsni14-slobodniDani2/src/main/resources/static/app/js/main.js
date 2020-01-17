var wafepaApp = angular.module("wafepaApp",["ngRoute"]);

wafepaApp.controller("RadniciCtrl", function($scope, $http, $location){
	var url = "/api/radnici";
	var urlSektori = "/api/sektori";
	
	
	
	$scope.radnici = [];
	$scope.sektori = [];
	
	$scope.knjiga = {};
	$scope.knjiga.naziv = "";
	$scope.knjiga.izdanje = "";
	$scope.knjiga.pisac = "";	
	$scope.knjiga.isbn = "";
	$scope.knjiga.izdavacId = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	$scope.sParams = {};
	$scope.sParams.idBroj = "";
	$scope.sParams.imeIPrezime = "";
	$scope.sParams.sektorId = "";
	
		
	
	
	var getRadnici = function(){			
			var config = {params:{}};
			
			if($scope.sParams.idBroj != ""){
				config.params.idBroj = $scope.sParams.idBroj;
			}
			
			if($scope.sParams.imeIPrezime != ""){
				config.params.imeIPrezime = $scope.sParams.imeIPrezime;
			}
			if($scope.sParams.sektorId != ""){
				config.params.sektorId = $scope.sParams.sektorId;
			}
			
			config.params.pageNum = $scope.pageNum;
			
			var promise = $http.get(url, config);
			promise.then(
				function success(res){
					$scope.totalPages = res.headers("totalPages");
					$scope.radnici = res.data;
				},
				function error(){
					alert("Neuspesno dobavljanje radnika!");
				}
			);
	}	
	getRadnici();
	
	var getSektori = function(){
		var promise = $http.get(urlSektori);
		promise.then(
			function success(res){
				$scope.sektori = res.data;
			},
			function error(res){
				alert("Neuspesno dobavljanje sektora!");
			}
		);
	}
	getSektori();
	
	$scope.changePage = function(direction){
		$scope.pageNum += direction;
		getRadnici();
	}
	
	$scope.doClear = function(){
		$scope.sParams.idBroj = "";
		$scope.sParams.imeIPrezime = "";
		$scope.sParams.sektorId = "";
		getRadnici();
	}
	
	$scope.doObrisi = function(id){
		var promise = $http.delete(url + "/" + id);
		promise.then(
			function success(){
				getRadnici();
			},
			function error(){
				alert("Neuspesno brisanje radnika!");
			}
		);
	}
	
	$scope.goToAdd = function(){
		$location.path("/radnici/add");
	}
	
	
	$scope.goToEdit = function(id){
		$location.path("/radnici/edit/" + id);
	}
	
	$scope.doSearch = function(){
		$scope.pageNum = 0;
		getRadnici();
	}
	
	$scope.goToGodisnji = function(id){
		$location.path("/radnici/godisnji/" + id);
	}
	
	
});




wafepaApp.controller("EditRadnikCtrl", function($scope, $http, $routeParams, $location){
	
	var urlRadnik = "/api/radnici/" + $routeParams.id;
	var urlSektori = "/api/sektori";
	
	$scope.sektori = [];

	$scope.radnik = {};
	$scope.radnik.idBroj = "";
	$scope.radnik.imeIPrezime = "";
	$scope.radnik.email = "";
	$scope.radnik.godineStaza = "";
	$scope.radnik.sektorId = "";


	
	
	var getSektori = function(){
		var promise = $http.get(urlSektori);
		promise.then(
			function success(res){
				$scope.sektori = res.data;
				getRadnik();
			},
			function error(res){
				alert("Neuspesno dobavljajne sektora!");
			}
		);
	}
	
	var getRadnik = function(){
		$http.get(urlRadnik).then(
			function success(res){
				$scope.radnik = res.data;
			},
			function error(){
				alert("Neuspesno dobavljanje radnika!");
			}
		);
	}
	getSektori();
	
	$scope.doEdit = function(){
		$http.put(urlRadnik, $scope.radnik).then(
			function success(){
				$location.path("/radnici");
			},
			function error(){
				alert("Nesto je poslo po zlu.");
			}
		);
	}
});

wafepaApp.controller("GodisnjiCtrl", function($scope, $http, $routeParams, $location){
	
	var urlRadnik = "/api/radnici/" + $routeParams.id;
	var urlGodisnji = "/api/radnici/godisnji/" + $routeParams.id;
	

	$scope.radnik = {};
	$scope.radnik.idBroj = "";
	$scope.radnik.imeIPrezime = "";
	$scope.radnik.email = "";
	$scope.radnik.godineStaza = "";
	$scope.radnik.sektorId = "";

	$scope.godisnji = {};
	$scope.godisnji.datumPocetka = "";
	$scope.godisnji.datumKraja = "";
	$scope.godisnji.radnihDana = "";
	
	
	
	
	var getRadnik = function(){
		$http.get(urlRadnik).then(
			function success(res){
				$scope.radnik = res.data;
			},
			function error(){
				alert("Neuspesno dobavljanje radnika!");
			}
		);
	}
	getRadnik();
	
	$scope.doGodisnji = function(){
		$http.post(urlGodisnji, $scope.godisnji).then(
			function success(){
				$location.path("/radnici");
			},
			function error(){
				alert("Nesto je poslo po zlu.");
			}
		);
	}
});



wafepaApp.controller("AddRadnikCtrl", function($scope, $http, $location){

	var urlRadnici = "/api/radnici";
	var urlSektori = "/api/sektori";
	
	$scope.sektori = [];

	$scope.radnik = {};
	$scope.radnik.idBroj = "";
	$scope.radnik.imeIPrezime = "";
	$scope.radnik.email = "";
	$scope.radnik.godineStaza = "";
	$scope.radnik.sektorId = "";


	var getSektori = function(){
		var promise = $http.get(urlSektori);
		promise.then(
			function success(res){
				$scope.sektori = res.data;
			},
			function error(res){
				alert("Neuspesno dobavljajne sektora!");
			}
		);
	}
	getSektori();
	
	$scope.doAdd = function(){
		$http.post(urlRadnici, $scope.radnik).then(
			function success(res){
				$location.path("/radnici");
		
			},
			function error(){
				alert("Neuspesno dodavanje radnika!");
			}
		);
	}
	
});


wafepaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/radnici.html',
			controller: "RadniciCtrl"
		})
		.when('/radnici', {
			templateUrl : '/app/html/radnici.html',
		})
		.when('/radnici/add', {
			templateUrl : '/app/html/add-radnik.html',
		})

		.when('/radnici/edit/:id', {
			templateUrl : '/app/html/edit-radnik.html'
		})
		.when('/radnici/godisnji/:id', {
			templateUrl : '/app/html/godisnji.html'
		})
		
		
		.otherwise({
			redirectTo: '/'
		});
}]);