# Hospital-Refatoramento

# Smells-Tratados:

* No pacote Control, existe uma classe chamada AdminManager que tem como objetivo realizar a interação entre o administrador e o sistema. Nela, existe um método chamado AdminManageEmployees e este método realizava duas operações diferentes (cadastro e remoção de empregados) com alta responsabilidade no mesmo método. Este problema configura um Smell do tipo Long Method. A solução dividir a grande responsabilidade do método AdminManageEmployees em dois novos métodos que trabalham exclusivamente com o cadastro (adminRegisterEmployees) ou remoção (adminRemoveEmployees) de empregados. Padrão utilizado: Extract Method. Além disso, o método foi suavizado com a implementação de outros métodos na classe Exceptions para verificação mais precisa de entradas, pois ele possuia muitos loops de verificação.

* Outro Smell

* Outro Smell
