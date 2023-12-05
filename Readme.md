# Taller 4  - Fundamentos de programación funcional y concurrente

Implementción de multiplicación concurrente de matrices


## Integrantes
- Pedro Bernal Londoño
- Jota E. López Ramírez


Para poder utilizar ParVector fue necesario incluir la dependencia en el archivo `build.gradle`:

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
para correr los tests ejecutar el siguiente comando:
```bash
    ./gradlew test
```

Antes de ejecutar el proyecto revisar el main en `app/src/main/scala/taller4/Taller4.scala` y descomentar el caso que se desea ejecutar.

Existe 3 implementaciones para comparar distintos casos:
1. Multiplicación de matrices de forma secuencial vs Multiplicación de matrices de forma concurrente
2. Producto punto de vectores de forma secuencial vs Producto punto de vectores de forma concurrente
3. Multiplicación de matrices de forma secuencial vs Multiplicación de matrices de forma concurrente utilizando ParVector


Para el caso **1** puede ajustar los algoritmos a comparar modificando las linea 31 y 32 del archivo Taller4.scala

```scala
    new MultiplicacionMatriz().multMatrizRecursiva,
    new MultiplicacionMatriz().multMatrizRecursivaPar
```
puede elegir entre las siguientes implementaciones:

```scala
    new MultiplicacionMatriz().multMatriz,
    new MultiplicacionMatriz().multMatrizPar,
    new MultiplicacionMatriz().multMatrizRecursiva,
    new MultiplicacionMatriz().multMatrizRecursivaPar,
    new MultiplicacionMatriz().multStrassen,
    new MultiplicacionMatriz().multStrassenPar
```
Para los casos **1** y **3** puede ajustar el tamaño que se van a multiplicar, es importante tener en cuenta que el tamaño de la matriz debe ser potencia de 2.

```scala
    i <- 1 to 10
    m1 = utils.matrizAlAzar(math.pow(2, i).toInt, 2)
    m2 = utils.matrizAlAzar(math.pow(2, i).toInt, 2)
```
Para el caso **2** puede ajustar el tamaño de los vectores que se calcular el producto punto, en este caso no es necesario que el tamaño sea potencia de 2.

```scala
    i <- 1 to 10
    v1 = utils.vectorAlAzar(math.pow(10, i).toInt)
    v2 = utils.vectorAlAzar(math.pow(10, i).toInt)
```  

Después de ajustar los parámetros deseado ejecutar el siguiente comando para correr el proyecto:

```bash
    ./gradlew run
```

## Resultados comparativos de la implementación secuencial y concurrente

Acontinuación se presentan los resultados de la ejecución de las diferentes implementaciones de la multiplicación de matrices de forma secuencial y concurrente.

#### 1. multMatriz vs multMatrizPar

| Dimension | Secuencial   | Paralelo     | Aceleración  |
|-----------|--------------|--------------|--------------|
| 2x2       | 0.141129     | 0.431482     | 0.32707969277976834  |
| 4x4       | 0.123936     | 0.480266     | 0.2580569934161486   |
| 8x8       | 0.265727     | 1.299917     | 0.20441843594629502  |
| 16x16     | 0.565938     | 0.522054     | 1.08406026962728     |
| 32x32     | 2.767554     | 2.5659       | 1.0785899684321292   |
| 64x64     | 6.285167     | 4.272541     | 1.471060663900007    |
| 128x128   | 55.105048    | 32.384131    | 1.7016065059766465   |
| 256x256   | 457.417766   | 243.14107    | 1.8812854858292758   |
| 512x512   | 3534.412609  | 2526.817195  | 1.3987607081326672   |
| 1024x1024 | 29265.957697 | 16304.400746 | 1.7949729127076255   |

---

### 2. multMatrizRecursiva vs multMatrizRecursivaPar

| Dimension | Secuencial   | Paralelo     | Aceleración  |
|-----------|--------------|--------------|--------------|
| 2x2       | 0.520271     | 0.163422     | 3.1836044106668626   |
| 4x4       | 0.829601     | 0.515041     | 1.6107474938888362   |
| 8x8       | 1.649964     | 1.540316     | 1.0711853931271245   |
| 16x16     | 4.852387     | 3.496523     | 1.3877749409913793   |
| 32x32     | 66.2469      | 44.706933    | 1.4818037282942222   |
| 64x64     | 623.579533   | 372.186037   | 1.6754511749724774   |
| 128x128   | 7838.590092  | 4140.910391  | 1.892962984428899    |
| 256x256   | 96653.731048 | 53722.957913 | 1.7991140994977033   |
| 512x512   |              |              |                      |
| 1024x1024 |              |              |                      |

---

### 3. multStrassen vs multStrassenPar

| Dimension | Secuencial    | Paralelo      | Aceleración  |
|-----------|---------------|---------------|--------------|
| 2x2       | 0.212623      | 0.266244      | 0.7986020342242455   |
| 4x4       | 0.344653      | 0.663266      | 0.5196301333100144   |
| 8x8       | 0.555522      | 0.821276      | 0.6764132885899502   |
| 16x16     | 3.737419      | 3.846555      | 0.9716275992413992   |
| 32x32     | 13.186677     | 20.495109     | 0.6434060438517307   |
| 64x64     | 102.131656    | 55.481477     | 1.84082438901185     |
| 128x128   | 729.914031    | 391.808502    | 1.8629356618708597   |
| 256x256   | 4843.947296   | 2613.450395   | 1.8534682369588271   |
| 512x512   | 32472.626935  | 18973.739096  | 1.711451115180866    |
| 1024x1024 | 237095.441557 | 136106.809686 | 1.74198074368198     |

---

### 4. multMatrizParD vs multMatrizParParD  - Utilizando ParVector

| Dimension | Secuencial    | Paralelo      | Aceleración  |
|-----------|---------------|---------------|--------------|
| 2x2       | 1.558168      | 0.584826      | 2.6643275093788583   |
| 4x4       | 2.026636      | 1.369114      | 1.480253653092438    |
| 8x8       | 9.181567      | 1.947989      | 4.713356697599422    |
| 16x16     | 21.560716     | 4.496052      | 4.795477454442253    |
| 32x32     | 69.17674      | 19.190857     | 3.6046717455088113   |
| 64x64     | 313.617093    | 202.881212    | 1.5458163420277675   |
| 128x128   | 1421.377187   | 1354.408526   | 1.0494449493741596   |
| 256x256   | 6643.26411    | 16012.428625  | 0.4148817312839076   |
| 512x512   | 28793.905265  | 92478.731769  | 0.3113570516616023   |
| 1024x1024 |               |               |                      |

--

### 5. Comparar prodPunto y prodPuntoPar con diferentes longitudes de vectores

| Tamaño del Vector | Secuencial    | Paralelo      | Aceleración  |
|-------------------|---------------|---------------|--------------|
| 10                | 0.059793      | 1.084469      | 0.05513573924197004 |
| 100               | 0.083038      | 0.573799      | 0.1447161811017447  |
| 1000              | 0.609687      | 0.692174      | 0.8808290978857918  |
| 10000             | 0.929695      | 2.090869      | 0.4446452647200757  |
| 100000            | 5.890912      | 5.725828      | 1.0288314633272253  |
| 1000000           | 34.775707     | 31.030398     | 1.1206980651682261  |
| 10000000          | 268.999511    | 848.385006    | 0.3170724483548923  |
| 100000000         |               |               |                     |

*Exception in thread "main" java.lang.OutOfMemoryError: Java heap space*

--

## Conclusiones

- La implementación de la multiplicación de matrices de forma concurrente no siempre es más rápida que la implementación secuencial, esto se debe a que el costo de crear los hilos y sincronizarlos es mayor que el costo de realizar la operación de forma secuencial.
- Algunas implementaciones de la multiplicación de matrices de forma concurrente son más rápidas que otras, esto se debe a que algunas implementaciones utilizan más hilos que otras, por lo que el costo de crear los hilos y sincronizarlos es mayor que el costo de realizar la operación de forma secuencial.

