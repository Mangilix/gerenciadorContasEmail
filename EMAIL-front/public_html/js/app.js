            var app = angular.module('usuariosApp', []);
            
            app.controller('UsuariosController', function($scope, UsuarioService) {
                
                $scope.usuario = {};
                
                listar();
                
                function listar(){
                    UsuarioService.listar().then(function(resposta) {
                        $scope.usuarios = resposta.data;   
                    });
                }
                
                $scope.salvar = function(usuario){
                    UsuarioService.salvar(usuario).then(listar);
                    $scope.usuario = {};
                }
                
                $scope.editar = function(usuario){
                    $scope.usuario = angular.copy(usuario);
                }
                
                $scope.excluir = function(usuario){
                    UsuarioService.excluir(usuario).then(listar);
                }
                
                $scope.cancelar = function(){
                    $scope.usuario = {};
                }
                
            });
        
            app.service('UsuarioService', function($http){
               
                var api = "http://localhost:8080/api/webresources/usuario";
               
                this.listar = function(){
                     return $http.get(api);
                };
            
                this.salvar = function(usuario){
                    if(usuario.codigo){
                        return $http.put(api + '/' + usuario.codigo, usuario);
                    }else{
                        return $http.post(api, usuario);
                    }
                }
                
                this.excluir = function(usuario){
                    return $http.delete(api + '/' + usuario.codigo);
                }
                });