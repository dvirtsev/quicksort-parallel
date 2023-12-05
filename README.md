Сравнение скорости находится в `BenchmarkTests`

Результаты запуска

- Для 1_000:

```
Sequential runs: [1.278599ms, 224.5us, 164.9us, 168.4us, 160.101us, 166.2us, 150.6us, 149.7us, 150.5us, 148.8us]
Sequential average runtime: 276.23us
Parallel runs: [1.870001ms, 3.410001ms, 746.5us, 724.699us, 628.899us, 579.6us, 474.9us, 476.6us, 766.499us, 483.9us]
Parallel average runtime: 1.016159ms
```

- Для 10_000

```
Sequential runs: [1.795499ms, 1.918900ms, 1.261999ms, 832.6us, 795.5us, 774.9us, 780us, 777.9us, 771.6us, 807us]
Sequential average runtime: 1.051589ms
Parallel runs: [5.702001ms, 2.454400ms, 964.7us, 835.799us, 869.201us, 842.701us, 849.5us, 829.2us, 885.7us, 1.238400ms]
Parallel average runtime: 1.547160ms
```

- Для 100_000

```
Sequential runs: [10.506200ms, 11.227999ms, 11.481500ms, 10.425800ms, 9.598900ms, 9.273100ms, 11.161ms, 11.124100ms, 10.938699ms, 10.787900ms]
Sequential average runtime: 10.652519ms
Parallel runs: [3.567401ms, 3.470700ms, 3.872399ms, 4.444901ms, 3.575900ms, 4.209500ms, 3.604200ms, 3.352300ms, 3.479999ms, 3.885001ms]
Parallel average runtime: 3.746230ms
```

- Для 1_000_000

```
Sequential runs: [152.18ms, 144.447501ms, 140.958201ms, 156.737500ms, 204.463100ms, 136.677ms, 149.464300ms, 140.346799ms, 151.869500ms, 158.941800ms]
Sequential average runtime: 153.608570ms
Parallel runs: [49.882300ms, 80.996999ms, 86.676200ms, 42.474800ms, 40.938301ms, 48.930099ms, 67.565800ms, 41.212099ms, 69.057001ms, 44.686199ms]
Parallel average runtime: 57.241979ms
```

- Для 10_000_000

```
Sequential runs: [2.178673101s, 2.136983600s, 2.117156501s, 2.147074999s, 2.167174299s, 2.135182601s, 2.138133900s, 2.125872999s, 2.078847400s, 2.133635s]
Sequential average runtime: 2.135873440s
Parallel runs: [926.335300ms, 688.566400ms, 624.290400ms, 716.719800ms, 639.441ms, 659.206401ms, 672.800200ms, 1.181347701s, 827.148700ms, 647.985101ms]
Parallel average runtime: 758.384100ms
```