PGDMP     5    #                 x            postgres    10.7    10.7     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �            1259    16412    dbt_student    TABLE     �  CREATE TABLE public.dbt_student (
    name character varying(3) NOT NULL,
    id character varying(18) NOT NULL,
    num character varying(12) NOT NULL,
    password text NOT NULL,
    institute character varying(5) NOT NULL,
    major character varying(5) NOT NULL,
    class character varying(5) NOT NULL,
    code character varying(2) NOT NULL,
    day integer NOT NULL,
    clockin integer NOT NULL,
    date character varying(10),
    phone character varying(11)
);
    DROP TABLE public.dbt_student;
       public         postgres    false            �
          0    16412    dbt_student 
   TABLE DATA               x   COPY public.dbt_student (name, id, num, password, institute, major, class, code, day, clockin, date, phone) FROM stdin;
    public       postgres    false    199   �       x
           2606    16554    dbt_student dbt_student_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.dbt_student
    ADD CONSTRAINT dbt_student_pkey PRIMARY KEY (num);
 F   ALTER TABLE ONLY public.dbt_student DROP CONSTRAINT dbt_student_pkey;
       public         postgres    false    199            �
     x�}S�NA}���5]U}�G�#	�>�1�E��hvxK��H����3�3�_P=Ww�N:����s�N�.w���0�H1�i�X�d�ze�E�
:tu���f�����'�C�|YL��A�o�FʎYM�٘$�N��gY���WN199({+?@����a�(g���Ǘb��?�Rf �"�l����(�B���R��%�nȡH���PLO��(���W�:/���=��NDC�֦�$����2B��jf�=th_|�}U?�DF��8�u��QGc��#]k�x���:�1���HU�7{��T��&Ϯ�e�B�����r��XF~Z��2]k4q��n?�T�"˭7�ђ�������ۛ:Ck䩳R>k��a<n����m?RB'�wh���cx!2Y���_���+%�
��p0˝aj��j:�#h�)�l��F��M�.M�u:y�G/Hb��8�� ���c(���h�7A�P>��tUs�'j�P������Ayyw����;;����\ �l=H��3WO�     