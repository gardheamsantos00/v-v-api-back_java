//controller
appCliente.controller("pessoaController", function($scope, $http){
	
	$scope.tituloButon = 'Salvar';
	$scope.pessoas=[];
	$scope.pessoa={};
	$scope.funcaopessoa = ["DIRETOR", "ATOR"];
	
	
	carregarPessoas = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/buscaPessoa'})
			.then(function (response) {
				$scope.pessoas = response.data;
			  }, function (response) {
				  console.log(response.data);
				  console.log(response.status);
			  });
	};
	
	$scope.addRow = function(){		
		$scope.nome='';
		$scope.funcao='';
	};
	
	
	$scope.salvarPessoa = function(){
		$http({
			  method: 'POST',
			  url: 'http://localhost:8080/cadastrarPessoa',
			  data: $scope.pessoa})
			.then(function (response) {
				
				//$scope.pessoas.push(response.data);
				carregarPessoas();
				$scope.cancelarEdit();
				
			  }, function (response) {
				  console.log(response.data);
				  console.log(response.status);
			  });
		
	};
	
	$scope.alterarPessoa = function(pessoa){
		$scope.pessoa = angular.copy(pessoa);
		
		
		
	};
	
	
	
	$scope.excluirPessoa = function(pessoa) {
		$http({
			  method: 'DELETE',
			  url: 'http://localhost:8080/removerPessoa/'+ pessoa.id,
			  data: $scope.pessoa})
			.then(function (response) {
				pos =$scope.pessoas.indexOf(pessoa);
				$scope.pessoas.splice(pos, 1);
				
			  }, function (response) {
				  console.log(response.data);
				  console.log(response.status);
			  });
		
		
	};
	
	
	
	
	$scope.cancelarEdit = function(){
		$scope.pessoa = {};
	};
	

	
	carregarPessoas();
	
	});