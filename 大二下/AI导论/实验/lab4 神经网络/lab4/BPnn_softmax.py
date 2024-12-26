# BP神经网络数字识别实验
import tensorflow as tf  #导入tensorflow，http://www.tensorfly.cn/tfdoc/api_docs/python
import random
import matplotlib.pyplot as plt
from tensorflow.examples.tutorials.mnist import input_data
tf.set_random_seed(777)  # reproducibility

print(tf.__version__)
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)##训练和测试的数据集
# Check out https://www.tensorflow.org/get_started/mnist/beginners for
# more information about the mnist dataset

# parameters 参数设置
learning_rate = 0.001  #学习率
training_epochs = 15   #迭代次
batch_size = 100       #每批大小

global_step = tf.Variable(0, trainable=False)

# input place holders 定义输入、输出样本数据
X = tf.placeholder(tf.float32, [None, 784])
Y = tf.placeholder(tf.float32, [None, 10])

# weights & bias for nn layers 隐层的连接权值和偏置
w1 = tf.get_variable('w1',shape=[784,512],initializer=tf.contrib.layers.xavier_initializer())
b1 = tf.Variable(tf.random_normal([512]))
a1 = tf.nn.relu(tf.matmul(X,w1) + b1)

w2 = tf.get_variable('w2',shape=[512,512],initializer=tf.contrib.layers.xavier_initializer())
b2 = tf.Variable(tf.random_normal([512]))
a2 = tf.nn.relu(tf.matmul(a1,w2) + b2)

w3 = tf.get_variable('w3',shape=[512,512],initializer=tf.contrib.layers.xavier_initializer())
b3 = tf.Variable(tf.random_normal([512]))
a3 = tf.nn.relu(tf.matmul(a2,w3) + b3)

w4 = tf.get_variable('w4',shape=[512,10],initializer=tf.contrib.layers.xavier_initializer())
b4 = tf.Variable(tf.random_normal([10]))
hypothesis = tf.nn.relu(tf.matmul(a3,w4) + b4)


reg1 = tf.contrib.layers.l2_regularizer(0.003)(w1)
reg2 = tf.contrib.layers.l2_regularizer(0.003)(w2)
reg3 = tf.contrib.layers.l2_regularizer(0.003)(w3)
reg4 = tf.contrib.layers.l2_regularizer(0.003)(w4)
# define cost/loss & optimizer 定义softmax回归后的交叉熵为损失函数，
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(
    logits=hypothesis, labels=Y)+ reg1 + reg2 + reg3 + reg4)
#optimizer =tf.train.GradientDescentOptimizer(learning_rate=learning_rate).minimize(cost)#选择梯度下降法作为误差反向传播学习算法
#optimizer =tf.train.MomentumOptimizer(learning_rate,0.5).minimize(cost)#动量学习算法
optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate).minimize(cost)#adam学习算法

# initialize初始化
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# train my model 神经网络训练
for epoch in range(training_epochs):
    avg_cost = 0
    total_batch = int(mnist.train.num_examples / batch_size) #训练样本总的批数

    for i in range(total_batch):
        batch_xs, batch_ys = mnist.train.next_batch(batch_size)##获取一批训练样本
        feed_dict = {X: batch_xs, Y: batch_ys}
        c, _ = sess.run([cost, optimizer], feed_dict=feed_dict)# 输入训练样本，训练学习，并返回损失函数
        avg_cost += c / total_batch #累计网络损失函数

    print('Epoch:', '%04d' % (epoch + 1), 'cost =', '{:.9f}'.format(avg_cost))

print('Learning Finished!')

# Test model and check accuracy 神经网络测试
correct_prediction = tf.equal(tf.argmax(hypothesis, 1), tf.argmax(Y, 1))#检测预测是否真实标签匹配(索引位置一样表示匹配)，返回布尔值
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
print('Accuracy:', sess.run(accuracy, feed_dict={
      X: mnist.test.images, Y: mnist.test.labels})) #输入测试样本数据，计算所学习到的模型在测试数据集上面的正确率


# Get one and predict 预测
r = random.randint(0, mnist.test.num_examples - 1) #随机选择一张测试图片
print("Label: ", sess.run(tf.argmax(mnist.test.labels[r:r + 1], 1)))#读取测试数据的标签
print("Prediction: ", sess.run(
    tf.argmax(hypothesis, 1), feed_dict={X: mnist.test.images[r:r + 1]}))#输入测试数据，获取训练后模型的输出结果

plt.imshow(mnist.test.images[r:r + 1].
    reshape(28, 28), cmap='Greys', interpolation='nearest') #绘制测试图片
plt.show()

'''
Epoch: 0001 cost = 5.888845987
Epoch: 0002 cost = 1.860620173
Epoch: 0003 cost = 1.159035648
Epoch: 0004 cost = 0.892340870
Epoch: 0005 cost = 0.751155428
Epoch: 0006 cost = 0.662484806
Epoch: 0007 cost = 0.601544010
Epoch: 0008 cost = 0.556526115
Epoch: 0009 cost = 0.521186961
Epoch: 0010 cost = 0.493068354
Epoch: 0011 cost = 0.469686249
Epoch: 0012 cost = 0.449967254
Epoch: 0013 cost = 0.433519321
Epoch: 0014 cost = 0.419000337
Epoch: 0015 cost = 0.406490815
Learning Finished!
Accuracy: 0.9035
'''
