package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    private val list = listOf<Dish>(
        Dish(
            1,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
            "1"
        ),
        Dish(
            2,
            "123",
            "Баварские колбаски",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
            "1"
        ),
        Dish(
            3,
            "123",
            "Нежный лосось",
            "Лосось, томаты, оливки,соус песто,помидорки черри",
            "1"
        ),
        Dish(
            4,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
            "1"
        ),
        Dish(
            4,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
            "1"
        ),
        Dish(
            4,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
            "1"
        )
    )

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        adapter = Adapter()

        binding.dishesRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.dishesRecycler.adapter = adapter

        adapter.submitList(list)

        return binding.root
    }
}