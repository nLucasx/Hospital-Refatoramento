# Hospital-Refatoramento

# Smells-Tratados:

* No pacote Control, existe uma classe chamada AdminManager que tem como objetivo realizar a interação entre o administrador e o sistema. Nela, existe um método chamado AdminManageEmployees e este método realizava duas operações diferentes (cadastro e remoção de empregados) com alta responsabilidade no mesmo método. Este problema configura um Smell do tipo Long Method. A solução dividir a grande responsabilidade do método AdminManageEmployees em dois novos métodos que trabalham exclusivamente com o cadastro (adminRegisterEmployees) ou remoção (adminRemoveEmployees) de empregados. Padrão utilizado: Extract Method. Além disso, o método foi suavizado com a implementação de outros métodos na classe Exceptions para verificação mais precisa de entradas, pois ele possuia muitos loops de verificação.

* No pacote Control, existe uma classe chamada Admin que tem como objetivo realizar todas as mudanças administrativas no sistema da clínica. Nela, existem dois métodos chamados showProducts (utilizando a técnica de Overload) que basicamente realizam a mesma operação de mostrar os produtos da clínica, só possuem pequenas diferenças. Isso configura um Smell do tipo Duplicated Code.

* Ainda na classe Admin, existe um método chamado returnIndexOfPerson, que tem como objetivo identificar em que posição do ArrayList se encontram as informações de um empregado da clínica. Esta busca é feita pelo cpf. No código antigo, existia um if para verificar se o cpf passado como parâmetro para o método era igual ao de um usuário cadastrado, porém esta verificação era feita através de um smell do tipo Message Chains. Para resolver este problema, eu criei um método novo, na classe Person dentro do pacote Model, chamado isMySsn. Este método retorna se os dois cpfs são iguais. Dessa forma o Message Chains pode ser retirado.

* O padrão apresentado no meu seminário de Padrões de Projeto foi o Iterator. Este padrão também foi usado neste código refatorado, pois no código antigo o iterator não era utilizado.
Exemplos de métodos que utilizei o Iterator:
returnIndexOfPerson.
