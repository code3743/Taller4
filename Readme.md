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

    <==========---> 80% EXECUTING [1h 14m 56s] faltaron 2 comprobaciones

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
    Tiempo secuencial: 0.47136
    Tiempo paralelo: 0.330262
    Aceleración: 1.4272305018439906
    Multiplicando matrices de 4x4
    Tiempo secuencial: 1.456916
    Tiempo paralelo: 0.360492
    Aceleración: 4.041465552633624
    Multiplicando matrices de 8x8
    Tiempo secuencial: 1.430855
    Tiempo paralelo: 0.767605
    Aceleración: 1.864051172152344
    Multiplicando matrices de 16x16
    Tiempo secuencial: 8.123346
    Tiempo paralelo: 1.149941
    Aceleración: 7.064141551610038
    Multiplicando matrices de 32x32
    Tiempo secuencial: 51.863244
    Tiempo paralelo: 12.081979
    Aceleración: 4.292611665688212
    Multiplicando matrices de 64x64
    Tiempo secuencial: 350.443074
    Tiempo paralelo: 47.401063
    Aceleración: 7.393147997545962
    Multiplicando matrices de 128x128
    Tiempo secuencial: 2456.249043
    Tiempo paralelo: 557.041622
    Aceleración: 4.409453344224249
    Multiplicando matrices de 256x256
    Tiempo secuencial: 18623.948903
    Tiempo paralelo: 2620.830781
    Aceleración: 7.106124148883002
    Multiplicando matrices de 512x512

    <==========---> 80% EXECUTING [24m 50s] faltaron 2 comprobaciones

    Multiplicando matrices de 512x512
    Tiempo secuencial: 
    Tiempo paralelo:
    Aceleración: 
    Multiplicando matrices de 1024x1024
    Tiempo secuencial: 
    Tiempo paralelo: 
    Aceleración: 


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
    Multiplicando matrices de 512x512
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