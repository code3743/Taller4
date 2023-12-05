# Taller 4  - Fundamentos de programación funcional y concurrente

Implementción de multiplicación concurrente de matrices


## Integrantes
- Pedro Bernal Londoño
- Jota E. López Ramírez


Para poder utilizar ParVector es necesario incluir la dependencia en el archivo `build.gradle`:

```groovy
    dependencies {
        implementation 'org.scala-lang.modules:scala-parallel-collections_2.13:1.0.3'
    }
```

## Importante 
Ejecutar el siguiente comando:

```bash
    ./gradlew check
```
para construir el proyecto y poder ejecutarlo ejecutar el siguiente comando:
```bash
    ./gradlew build
```
```bash
    ./gradlew run
```
para correr los tests ejecutar el siguiente comando:
```bash
    ./gradlew test
```

### Resultados comparativos de la implementación secuencial y concurrente

Acontinuación se presentan los resultados de la ejecución de las diferentes implementaciones de la multiplicación de matrices de forma secuencial y concurrente.

#### 1. multMatriz vs multMatrizPar

    Multiplicando matrices de 2x2
    Tiempo secuencial: 0.141129
    Tiempo paralelo: 0.431482
    Aceleración: 0.32707969277976834
    Multiplicando matrices de 4x4
    Tiempo secuencial: 0.123936
    Tiempo paralelo: 0.480266
    Aceleración: 0.2580569934161486
    Multiplicando matrices de 8x8
    Tiempo secuencial: 0.265727
    Tiempo paralelo: 1.299917
    Aceleración: 0.20441843594629502
    Multiplicando matrices de 16x16
    Tiempo secuencial: 0.565938
    Tiempo paralelo: 0.522054
    Aceleración: 1.08406026962728
    Multiplicando matrices de 32x32
    Tiempo secuencial: 2.767554
    Tiempo paralelo: 2.5659
    Aceleración: 1.0785899684321292
    Multiplicando matrices de 64x64
    Tiempo secuencial: 6.285167
    Tiempo paralelo: 4.272541
    Aceleración: 1.471060663900007
    Multiplicando matrices de 128x128
    Tiempo secuencial: 55.105048
    Tiempo paralelo: 32.384131
    Aceleración: 1.7016065059766465
    Multiplicando matrices de 256x256
    Tiempo secuencial: 457.417766
    Tiempo paralelo: 243.14107
    Aceleración: 1.8812854858292758
    Multiplicando matrices de 512x512
    Tiempo secuencial: 3534.412609
    Tiempo paralelo: 2526.817195
    Aceleración: 1.3987607081326672
    Multiplicando matrices de 1024x1024
    Tiempo secuencial: 29265.957697
    Tiempo paralelo: 16304.400746
    Aceleración: 1.7949729127076255

---

### 2. multMatrizRecursiva vs multMatrizRecursivaPar

    Multiplicando matrices de 2x2
    Tiempo secuencial: 0.520271
    Tiempo paralelo: 0.163422
    Aceleración: 3.1836044106668626
    Multiplicando matrices de 4x4
    Tiempo secuencial: 0.829601
    Tiempo paralelo: 0.515041
    Aceleración: 1.6107474938888362
    Multiplicando matrices de 8x8
    Tiempo secuencial: 1.649964
    Tiempo paralelo: 1.540316
    Aceleración: 1.0711853931271245
    Multiplicando matrices de 16x16
    Tiempo secuencial: 4.852387
    Tiempo paralelo: 3.496523
    Aceleración: 1.3877749409913793
    Multiplicando matrices de 32x32
    Tiempo secuencial: 66.2469
    Tiempo paralelo: 44.706933
    Aceleración: 1.4818037282942222
    Multiplicando matrices de 64x64
    Tiempo secuencial: 623.579533
    Tiempo paralelo: 372.186037
    Aceleración: 1.6754511749724774
    Multiplicando matrices de 128x128
    Tiempo secuencial: 7838.590092
    Tiempo paralelo: 4140.910391
    Aceleración: 1.892962984428899
    Multiplicando matrices de 256x256
    Tiempo secuencial: 96653.731048
    Tiempo paralelo: 53722.957913
    Aceleración: 1.7991140994977033

    <==========---> 80% EXECUTING [48m 56s] faltaron 2 comprobaciones

    Multiplicando matrices de 512x512
    Tiempo secuencial: 
    Tiempo paralelo:
    Aceleración: 
    Multiplicando matrices de 1024x1024
    Tiempo secuencial: 
    Tiempo paralelo: 
    Aceleración: 


---


### 3. multStrassen vs multStrassenPar

    Multiplicando matrices de 2x2
    Tiempo secuencial: 0.212623
    Tiempo paralelo: 0.266244
    Aceleración: 0.7986020342242455
    Multiplicando matrices de 4x4
    Tiempo secuencial: 0.344653
    Tiempo paralelo: 0.663266
    Aceleración: 0.5196301333100144
    Multiplicando matrices de 8x8
    Tiempo secuencial: 0.555522
    Tiempo paralelo: 0.821276
    Aceleración: 0.6764132885899502
    Multiplicando matrices de 16x16
    Tiempo secuencial: 3.737419
    Tiempo paralelo: 3.846555
    Aceleración: 0.9716275992413992
    Multiplicando matrices de 32x32
    Tiempo secuencial: 13.186677
    Tiempo paralelo: 20.495109
    Aceleración: 0.6434060438517307
    Multiplicando matrices de 64x64
    Tiempo secuencial: 102.131656
    Tiempo paralelo: 55.481477
    Aceleración: 1.84082438901185
    Multiplicando matrices de 128x128
    Tiempo secuencial: 729.914031
    Tiempo paralelo: 391.808502
    Aceleración: 1.8629356618708597
    Multiplicando matrices de 256x256
    Tiempo secuencial: 4843.947296
    Tiempo paralelo: 2613.450395
    Aceleración: 1.8534682369588271
    Multiplicando matrices de 512x512
    Tiempo secuencial: 32472.626935
    Tiempo paralelo: 18973.739096
    Aceleración: 1.711451115180866
    Multiplicando matrices de 1024x1024
    Tiempo secuencial: 237095.441557
    Tiempo paralelo: 136106.809686
    Aceleración: 1.74198074368198

---

### 4. multMatrizParD vs multMatrizParParD  - Utilizando ParVector
    Multiplicando matrices de 2x2
    Tiempo secuencial: 1.558168
    Tiempo paralelo: 0.584826
    Aceleración: 2.6643275093788583
    Multiplicando matrices de 4x4
    Tiempo secuencial: 2.026636
    Tiempo paralelo: 1.369114
    Aceleración: 1.480253653092438
    Multiplicando matrices de 8x8
    Tiempo secuencial: 9.181567
    Tiempo paralelo: 1.947989
    Aceleración: 4.713356697599422
    Multiplicando matrices de 16x16
    Tiempo secuencial: 21.560716
    Tiempo paralelo: 4.496052
    Aceleración: 4.795477454442253
    Multiplicando matrices de 32x32
    Tiempo secuencial: 69.17674
    Tiempo paralelo: 19.190857
    Aceleración: 3.6046717455088113
    Multiplicando matrices de 64x64
    Tiempo secuencial: 313.617093
    Tiempo paralelo: 202.881212
    Aceleración: 1.5458163420277675
    Multiplicando matrices de 128x128
    Tiempo secuencial: 1421.377187
    Tiempo paralelo: 1354.408526
    Aceleración: 1.0494449493741596
    Multiplicando matrices de 256x256
    Tiempo secuencial: 6643.26411
    Tiempo paralelo: 16012.428625
    Aceleración: 0.4148817312839076
    <==========---> 80% EXECUTING [6m 22s] faltaron 2 comprobaciones
    
    Multiplicando matrices de 512x512
    Tiempo secuencial: 
    Tiempo paralelo:
    Aceleración: 
    Multiplicando matrices de 1024x1024
    Tiempo secuencial: 
    Tiempo paralelo: 
    Aceleración:  

--

### 5. Comparar prodPunto y prodPuntoPar con diferentes longitudes de vectores
    Comparando prodPunto de vectores de tamaño 10
    Tiempo secuencial: 0.059793
    Tiempo paralelo: 1.084469
    Aceleración: 0.05513573924197004
    Comparando prodPunto de vectores de tamaño 100
    Tiempo secuencial: 0.083038
    Tiempo paralelo: 0.573799
    Aceleración: 0.1447161811017447
    Comparando prodPunto de vectores de tamaño 1000
    Tiempo secuencial: 0.609687
    Tiempo paralelo: 0.692174
    Aceleración: 0.8808290978857918
    Comparando prodPunto de vectores de tamaño 10000
    Tiempo secuencial: 0.929695
    Tiempo paralelo: 2.090869
    Aceleración: 0.4446452647200757
    Comparando prodPunto de vectores de tamaño 100000
    Tiempo secuencial: 5.890912
    Tiempo paralelo: 5.725828
    Aceleración: 1.0288314633272253
    Comparando prodPunto de vectores de tamaño 1000000
    Tiempo secuencial: 34.775707
    Tiempo paralelo: 31.030398
    Aceleración: 1.1206980651682261
    Comparando prodPunto de vectores de tamaño 10000000
    Tiempo secuencial: 268.999511
    Tiempo paralelo: 848.385006
    Aceleración: 0.3170724483548923
    Comparando prodPunto de vectores de tamaño 100000000
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

## Conclusiones

- La implementación de la multiplicación de matrices de forma concurrente no siempre es más rápida que la implementación secuencial, esto se debe a que el costo de crear los hilos y sincronizarlos es mayor que el costo de realizar la operación de forma secuencial.
- La implementación de la multiplicación de matrices de forma concurrente utilizando ParVector es más rápida que la implementación secuencial, esto se debe a que ParVector utiliza un pool de hilos que se reutilizan para realizar las operaciones, por lo que el costo de crear los hilos y sincronizarlos es menor que el costo de realizar la operación de forma secuencial.
- Algunas implementaciones de la multiplicación de matrices de forma concurrente son más rápidas que otras, esto se debe a que algunas implementaciones utilizan más hilos que otras, por lo que el costo de crear los hilos y sincronizarlos es mayor que el costo de realizar la operación de forma secuencial.

