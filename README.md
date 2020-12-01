# kiraUID
基于SnowFlake算法的可定制UID生成器
## 食用方式
### 默认配置
```java
long workId = 1;
UidGenerator g = DefaultIdGenerator.createDefaultGenerator();
for (int i = 0; i < 5; i++) {
    System.out.println(g.nextId(workId));
}
```
#### 输出
6739574785627394048

6739574785631588352

6739574785631588353

6739574785631588354

6739574785631588355
### 自定义配置
```java
BitsConfig c = new BitsConfig();
c.addPart(BitsProperties.TIME); // 时间戳
c.addPart(BitsProperties.CUSTOM, 5); // 自定义参数 1
c.addPart(BitsProperties.CUSTOM, 5); // 自定义参数 2
c.addPart(BitsProperties.SEQUENCE); // 自增序列
c.setTwepoch(1420041600000L); // 设置起始时间（可以不设置）

BitsAllocator a = new BitsAllocator(c);
UidGenerator g = new DefaultIdGenerator(a);

long d1 = 1;
long d2 = 2;
for (int i = 0; i < 5; i++) {
    System.out.println(g.nextId(d1, d2));
}
```
#### 输出
783490216609587200

783490216609587201

783490216609587202

783490216609587203

783490216609587204
