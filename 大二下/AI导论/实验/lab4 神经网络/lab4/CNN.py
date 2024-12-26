#  MNIST and Convolutional Neural Network 简单的卷积神经网络数字识别实验
import tensorflow as tf  #导入tensorflow，http://www.tensorfly.cn/tfdoc/api_docs/python
import random
import matplotlib.pyplot as plt
from tensorflow.examples.tutorials.mnist import input_data

tf.set_random_seed(777)  # reproducibility

mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)##训练和测试的数据集
# Check out https://www.tensorflow.org/get_started/mnist/beginners for
# more information about the mnist dataset

# hyper parameters 参数设置
learning_rate = 0.001 #学习率
training_epochs = 15 #迭代次数
batch_size = 100  #每批大小

# input place holders 定义输入、输出样本数据
X = tf.placeholder(tf.float32, [None, 784])
X_img = tf.reshape(X, [-1, 28, 28, 1])   # img 28x28x1 (black/white)
Y = tf.placeholder(tf.float32, [None, 10])

# L1 ImgIn shape=(?, 28, 28, 1)输入图片维数
W1 = tf.Variable(tf.random_normal([3, 3, 1, 32], stddev=0.01))
#    Conv  卷积层输出      -> (?, 28, 28, 32)
#    Pool  池化层输出     -> (?, 14, 14, 32)
L1 = tf.nn.conv2d(X_img, W1, strides=[1, 1, 1, 1], padding='SAME')
L1 = tf.nn.relu(L1) #激活函数
L1 = tf.nn.max_pool(L1, ksize=[1, 2, 2, 1],
                    strides=[1, 2, 2, 1], padding='SAME')
'''
Tensor("Conv2D:0", shape=(?, 28, 28, 32), dtype=float32)
Tensor("Relu:0", shape=(?, 28, 28, 32), dtype=float32)
Tensor("MaxPool:0", shape=(?, 14, 14, 32), dtype=float32)
'''

# L2 ImgIn shape=(?, 14, 14, 32)
W2 = tf.Variable(tf.random_normal([3, 3, 32, 64], stddev=0.01))
#    Conv  卷积层输出        ->(?, 14, 14, 64)
#    Pool  池化层输出   ->(?, 7, 7, 64)
L2 = tf.nn.conv2d(L1, W2, strides=[1, 1, 1, 1], padding='SAME')
L2 = tf.nn.relu(L2) #激活函数
L2 = tf.nn.max_pool(L2, ksize=[1, 2, 2, 1],
                    strides=[1, 2, 2, 1], padding='SAME')
L2_flat = tf.reshape(L2, [-1, 7 * 7 * 64])
'''
Tensor("Conv2D_1:0", shape=(?, 14, 14, 64), dtype=float32)
Tensor("Relu_1:0", shape=(?, 14, 14, 64), dtype=float32)
Tensor("MaxPool_1:0", shape=(?, 7, 7, 64), dtype=float32)
Tensor("Reshape_1:0", shape=(?, 3136), dtype=float32)
'''

# Final FC 7x7x64 inputs -> 10 outputs 全连接层
W3 = tf.get_variable("W3", shape=[7 * 7 * 64, 10],
                     initializer=tf.contrib.layers.xavier_initializer())
b = tf.Variable(tf.random_normal([10]))

logits = tf.matmul(L2_flat, W3) + b  #神经网络输出

# define cost/loss(定义softmax回归后的交叉熵为损失函数) & optimizer
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(
    logits=logits, labels=Y))
optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate).minimize(cost)#adam学习算法
#optimizer =tf.train.MomentumOptimizer(learning_rate,0.5).minimize(cost)#动量学习算法
# initialize初始化
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# train my model 神经网络训练
print('Learning started. It takes sometime.')
for epoch in range(training_epochs): #
    avg_cost = 0
    total_batch = int(mnist.train.num_examples / batch_size) ##训练样本总的批数
    
    for i in range(total_batch):#total_batch = 55000/100=550批
        batch_xs, batch_ys = mnist.train.next_batch(batch_size)#获取一批训练样本 
        feed_dict = {X: batch_xs, Y: batch_ys}
        c, _ = sess.run([cost, optimizer], feed_dict=feed_dict)# 输入训练样本，训练学习，并返回损失函数
        avg_cost += c / total_batch#累计网络损失函数

    print('Epoch:', '%04d' % (epoch + 1), 'cost =', '{:.9f}'.format(avg_cost))

print('Learning Finished!')

# Test model and check accuracy 神经网络测试
correct_prediction = tf.equal(tf.argmax(logits, 1), tf.argmax(Y, 1))#检测预测是否真实标签匹配(索引位置一样表示匹配)，返回布尔值
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
print('Accuracy:', sess.run(accuracy, feed_dict={
      X: mnist.test.images, Y: mnist.test.labels}))#输入测试样本数据，计算所学习到的模型在测试数据集上面的正确率

# Get one and predict 预测
r = random.randint(0, mnist.test.num_examples - 1) #随机选择一张测试图片
print("Label: ", sess.run(tf.argmax(mnist.test.labels[r:r + 1], 1))) #读取测试数据的标签
print("Prediction: ", sess.run(
    tf.argmax(logits, 1), feed_dict={X: mnist.test.images[r:r + 1]})) #输入测试数据，获取训练后模型的输出结果

plt.imshow(mnist.test.images[r:r + 1].
           reshape(28, 28), cmap='Greys', interpolation='nearest')#绘制测试图片
plt.show()

'''
Epoch: 0001 cost = 0.340291267
Epoch: 0002 cost = 0.090731326
Epoch: 0003 cost = 0.064477619
Epoch: 0004 cost = 0.050683064
Epoch: 0005 cost = 0.041864835
Epoch: 0006 cost = 0.035760704
Epoch: 0007 cost = 0.030572132
Epoch: 0008 cost = 0.026207981
Epoch: 0009 cost = 0.022622454
Epoch: 0010 cost = 0.019055919
Epoch: 0011 cost = 0.017758641
Epoch: 0012 cost = 0.014156652
Epoch: 0013 cost = 0.012397016
Epoch: 0014 cost = 0.010693789
Epoch: 0015 cost = 0.009469977
Learning Finished!
Accuracy: 0.9885
'''
