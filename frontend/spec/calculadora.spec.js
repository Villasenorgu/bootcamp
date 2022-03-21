describe('Pruebas de la calculadora', () => {
    
    describe('Calcula', () => {
            it('Suma', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "+";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(15);
            });

            it('Resta', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "-";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(5);
            });

            it('Producto', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "*";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(50);
            });

            it('Division', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "÷";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(2);
            });

            it('Borrar', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "58";
                calculadora.borrar();

                expect(calculadora.operandoActual).toEqual("5");
            });

            it('Añadir Numero', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "58";
                calculadora.anadirNumero(0);

                expect(calculadora.operandoActual).toEqual("580");
            });
    });
})