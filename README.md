# Hospital-Refatoramento
# Aluno: Lucas Buarque de Araújo Barros
# Smells-Tratados:

* No pacote Control, existe uma classe chamada AdminManager que tem como objetivo realizar a interação entre o administrador e o sistema. Nela, existe um método chamado AdminManageEmployees e este método realizava duas operações diferentes (cadastro e remoção de empregados) com alta responsabilidade no mesmo método. Este problema configura um Smell do tipo Long Method. A solução dividir a grande responsabilidade do método AdminManageEmployees em dois novos métodos que trabalham exclusivamente com o cadastro (adminRegisterEmployees) ou remoção (adminRemoveEmployees) de empregados. Padrão utilizado: Extract Method. Além disso, o método foi suavizado com a implementação de outros métodos na classe Exceptions para verificação mais precisa de entradas, pois ele possuia muitos loops de verificação.

* No pacote Control, existe uma classe chamada Admin que tem como objetivo realizar todas as mudanças administrativas no sistema da clínica. Nela, existem métodos chamados AddEmployee (utilizando a técnica de Overload) que basicamente realizam a mesma operação de salvar o cadastro que foi solicitado na classe AdminManager, só possuem pequenas diferenças quanto ao tipo de empregado. Isso configura um Smell do tipo Duplicated Code. A solução foi deixar apenas um método AddEmployee e enviar como parâmetro apenas um objeto do tipo employee. Dessa forma podemos utilizar do polimorfismo e precisaremos apenas de um único método em vez de código duplicado

* Ainda na classe Admin, existe um método chamado returnIndexOfPerson, que tem como objetivo identificar em que posição do ArrayList se encontram as informações de um empregado da clínica. Esta busca é feita pelo cpf. No código antigo, existia um if para verificar se o cpf passado como parâmetro para o método era igual ao de um usuário cadastrado, porém esta verificação era feita através de um smell do tipo Message Chains. Para resolver este problema, eu criei um método novo, na classe Person dentro do pacote Model, chamado isMySsn. Este método retorna se os dois cpfs são iguais. Dessa forma o Message Chains pode ser retirado.
Antes -> if (this.allemployees.get(i).getSsn().equals(ssn)) return i <br>
Depois -> if (employee.isMySsn(ssn)) return index;

* O padrão apresentado no meu seminário de Padrões de Projeto foi o Iterator. Este padrão também foi usado neste código refatorado, pois no código antigo o iterator não era utilizado.
Exemplos de métodos que utilizei o Iterator:
returnIndexOfPerson. <br>
showAllEmployees. <br>
