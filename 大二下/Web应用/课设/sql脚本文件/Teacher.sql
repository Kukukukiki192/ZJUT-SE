PGDMP     %    $                 x            postgres    10.7    10.7     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �            1259    16409    dbt_teacher    TABLE     �  CREATE TABLE public.dbt_teacher (
    name character varying(3) NOT NULL,
    id character varying(18) NOT NULL,
    num character varying(12) NOT NULL,
    password text NOT NULL,
    institute character varying(5) NOT NULL,
    "character" character varying(5) NOT NULL,
    code character varying(2) NOT NULL,
    day integer NOT NULL,
    clockin integer NOT NULL,
    date character varying(10),
    phone character varying(11)
);
    DROP TABLE public.dbt_teacher;
       public         postgres    false            �
          0    16409    dbt_teacher 
   TABLE DATA               w   COPY public.dbt_teacher (name, id, num, password, institute, "character", code, day, clockin, date, phone) FROM stdin;
    public       postgres    false    198   �       x
           2606    16580    dbt_teacher dbt_teacher_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.dbt_teacher
    ADD CONSTRAINT dbt_teacher_pkey PRIMARY KEY (num);
 F   ALTER TABLE ONLY public.dbt_teacher DROP CONSTRAINT dbt_teacher_pkey;
       public         postgres    false    198            �
   �  x���Mn�@���w�UտW`�˹B�+$B�,B2	Q�(E�i��	\f����n��D���Ur�ޫr�U���!EJCJ"iD�{C!^}�����������'��4.^����� ��Z�1��3���B��݁�C��]��Q�q�l�;������v3uTP���Q�&|�f~(��"-?'f�{�o��|2�� ӗ*~�ī��5*�ǀP�b(�z��Xl�\��Su ,��=��壹G��<uY����`�9t,ܔ�y(��G����Q>b�6$�7����.o�� =O��~�̖��;r��Ծ�?̗-��BqH�EY�_�~��S@؃��>Sc
�~�ҼN������2;��{�n�X�z�]"/ۛ��u�ؙv��wr���K��zz��}��q�Z�s�O��1|ȹr��qa�-9~"��E5     